package org.ac.ios;

import org.testng.annotations.Test;
import java.util.HashMap;
import org.ac.pageObject.ios.AccountPageIos;
import org.ac.pageObject.ios.AdminPageIos;
import org.ac.pageObject.ios.CommunityPageIos;
import org.ac.pageObject.ios.HomePageIos;
import org.ac.testUtils.AciOSBase;

public class IOSNoticeBoard extends AciOSBase
{

	/*TEST SCENARIO : Check the current notices and pending for approval/expired notices are appearing for community admin / Notice board Admin
	Tc2, Tc3, Tc4 are integrated with NoticeBoard_Tc1 */

	@Test (dataProvider = "NBDetails", enabled = false)
	public void Ios_NoticeBoard_Tc1_Pending_4_Approval(HashMap<String, String> input) throws InterruptedException
	{

		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AdminPageIos adminios = homeios.tabAdmin();
		adminios.noticeCountAndClick();
		adminios.pendingNotice();
		adminios.approvedNotice();
		homeios = adminios.back();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);

	}


	/*TEST SCENARIO : Approve the notice which have attachments and check respective members receiving push notification and mails
		Tc5, Tc7, Tc9, Tc10 	integrated with NoticeBoard_Tc6 */
	//Known Issues :	CreatenNotice, attachment, 
	@Test (dataProvider = "NoticeDetails", enabled= false)
	public void Ios_NoticeBoard_Tc6_Approve_Reject_Delete_Notice(HashMap<String, String> input) throws InterruptedException 
	{	
		dateTime();
		loginios.setFieldEmail(input.get("emailMember"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		CommunityPageIos commios = homeios.tabCommunity();
		int noticeLoop;
		for (noticeLoop=0; noticeLoop<=2; noticeLoop++)
		{
			commios.createNotice();
			commios.setFieldNoticeSubject(input.get("noticeSub")+ " " +  dateTime());
			commios.setFieldNoticeDescription(input.get("noticeDesc")+ " " +  dateTime());
			commios.done();
			commios.addAttachment();
			commios.attachment(input.get("attach"));
			commios.accessGallery();
			commios.noticeSettings();
			commios.noticeExpDD();
			commios.noticeExpiry(input.get("noticeExp"));
			commios.noticeDone();
			commios.postNotice();
		}
		AccountPageIos accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);


		/*ADMIN LOGIN*/
		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		homeios = loginios.login();
		AdminPageIos adminios = homeios.tabAdmin();
		adminios.noticeCountAndClick();
		adminios.pendingNotice();

		/*APPROVE NOTICE*/
		//adminios.showmore();
		adminios.approve();
		adminios.setAudiance();
		adminios.selectAudi(input.get("visible"));
		adminios.selectCalander();
		adminios.calanderOk();
		adminios.approveNotice();

		/*DECLINE NOTICE 
		 *TestCase 8 
		 *TEST SCENARIO : Reject the notice and check notice rejected successfully */
		adminios.pendingNotice();
		adminios.declineNotice();
		adminios.setDeclineComment(input.get("declineComment"));
		adminios.rejectNotice(input.get("reject"));


		/*DELETE NOTICE
		 * TestCase 15
		 * TEST SCENARIO : Check admin able to delete the notice  */
		adminios.pendingNotice();
		adminios.moreOption();
		adminios.deleteNotice();
		adminios.delete(input.get("delete"));
		homeios = adminios.back();
		homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);

	}

	/*TEST SCENARIO : Edit the date  to current/future date for expired notice and check expired notice is appearing is disappeared in expired notice screen
		Tc12, Tc13, Tc14 integrated with NoticeBoard_Tc11 */
	//Known Issues : scroll to more "More button is not at all catchable"
	@Test (dataProvider = "NoticeDetails")
	public void Android_NoticeBoard_Tc11_Edit_The_Date(HashMap<String, String> input) throws InterruptedException
	{	

		loginios.setFieldEmail(input.get("email"));
		loginios.submit();
		loginios.setFieldPassword(input.get("pass"));
		HomePageIos homeios = loginios.login();
		AdminPageIos adminios = homeios.tabAdmin();
		adminios.noticeCountAndClick();
		adminios.approvedNotice();
		adminios.scrollToMore();
		adminios.editAccessLabel();
		adminios.setAudiance();
		adminios.selectAudi(input.get("visible"));
		adminios.selectCalander();
		adminios.calanderOk();
		adminios.update();
		//recheck code will go here 
		homeios = adminios.back();
		AccountPageIos accountios = homeios.tabAccount();
		accountios.logout();
		Thread.sleep(2000);	
		
	}

}



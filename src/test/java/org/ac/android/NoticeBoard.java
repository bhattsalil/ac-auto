package org.ac.android;

import org.testng.annotations.Test;
import java.util.HashMap;
import org.ac.pageObject.android.AccountPage;
import org.ac.pageObject.android.AdminPage;
import org.ac.pageObject.android.CommunityPage;
import org.ac.pageObject.android.HomePage;
import org.ac.testUtils.AcAndroidBase;

public class NoticeBoard extends AcAndroidBase
{
		/*TEST SCENARIO : Check the current notices and pending for approval/expired notices are appearing for community admin / Notice board Admin
		Tc2, Tc3, Tc4 are integrated with NoticeBoard_Tc1 */

	@Test (dataProvider = "NBDetails", enabled = false)
	public void Android_NoticeBoard_Tc1_Pending_4_Approval(HashMap<String, String> input) throws InterruptedException
	{
		login.checkbox();
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		HomePage home = login.login();
		AdminPage admin = home.tabAdmin();
		admin.noticeCountAndClick();
		admin.pendingNotice();
		admin.approvedNotice();
		home = admin.back();
		home.tabAccount();
		AccountPage account = home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);

	}

		/*TEST SCENARIO : Approve the notice which have attachments and check respective members receiving push notification and mails
		Tc5, Tc7, Tc9, Tc10 	integrated with NoticeBoard_Tc6 */
	
	@Test (dataProvider = "NoticeDetails", enabled = false)
	public void Android_NoticeBoard_Tc6_Approve_Reject_Delete_Notice(HashMap<String, String> input) throws InterruptedException 
	{	
		dateTime();
		login.checkbox();
		login.setfieldEmail(input.get("emailMember"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		HomePage home = login.login();
		CommunityPage comm = home.tabCommunity();
		int noticeLoop;
		for (noticeLoop=0; noticeLoop<=3; noticeLoop++)
		{	
		comm.createNotice();
		comm.setFieldNoticeSubject(input.get("noticeSub")+ " " +  dateTime());
		comm.setFieldNoticeDescription(input.get("noticeDesc")+ " " +  dateTime());	
		//comm.addAttachment();
		//comm.attachment(input.get("attach"));
		comm.noticeSettings();
		comm.noticeExpiry(input.get("noticeExp"));
		comm.postNotice();
		}
		AccountPage account = home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
		
			/*ADMIN LOGIN*/
		login.checkbox();
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		home = login.login();
		AdminPage admin = home.tabAdmin();
		admin.noticeCountAndClick();
		admin.pendingNotice();
			
			/*APPROVE NOTICE*/
		admin.approve();
		admin.setAudiance();
		admin.selectAudi(input.get("visible"));
		admin.selectCalander();
		admin.calanderOk();
		admin.approveNotice();

			/*DECLINE NOTICE 
			 *TestCase 8 
		 	 *TEST SCENARIO : Reject the notice and check notice rejected successfully */
		admin.pendingNotice();
		admin.declineNotice();
		admin.setDeclineComment(input.get("declineComment"));
		admin.rejectNotice(input.get("reject"));
		
		
			/*DELETE NOTICE
			 * TestCase 15
			 * TEST SCENARIO : Check admin able to delete the notice  */
		admin.moreOption();
		admin.deleteNotice();
		admin.delete(input.get("delete"));
		home = admin.back();
		account = home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
	}



		/*TEST SCENARIO : Edit the date  to current/future date for expired notice and check expired notice is appearing is disappeared in expired notice screen
			Tc12, Tc13, Tc14 integrated with NoticeBoard_Tc11 */
	@Test (dataProvider = "NoticeDetails")
	public void Android_NoticeBoard_Tc11_Edit_The_Date(HashMap<String, String> input) throws InterruptedException
	{	
		login.checkbox();
		login.setfieldEmail(input.get("email"));
		login.submit();
		login.setfieldPassword(input.get("pass"));
		HomePage home = login.login();
		AdminPage admin = home.tabAdmin();
		admin.noticeCountAndClick();
		admin.approvedNotice();
		admin.scrollToMore();
		admin.editAccessLabel();
		admin.setAudiance();
		admin.selectAudi(input.get("visible"));
		admin.selectCalander();
		admin.calanderOk();
		admin.approveNotice();
		admin.recheckNotice(input.get("txt"));
		home = admin.back();
		AccountPage account = home.tabAccount();
		account.logout();
		account.yes();
		Thread.sleep(2000);
		
	}
}

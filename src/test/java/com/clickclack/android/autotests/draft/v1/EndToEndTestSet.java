package com.clickclack.android.autotests.draft.v1;

import com.clickclack.android.autotests.AppiumAndroidTestSet;
import com.clickclack.android.autotests.pages.ClackUpdatePage;
import com.clickclack.android.autotests.pages.ClacksCreatePage;
import com.clickclack.android.autotests.pages.ClacksListPage;
import com.clickclack.android.autotests.pages.HomePage;
import org.testng.annotations.Test;

public class EndToEndTestSet extends AppiumAndroidTestSet {

    @Test(
            groups = {"e2e"},
            description = "I can CRUD Clacks"
    )
    public void testCRUDClack() {
        prepareTest();
        new HomePage(mobileDriver)
                .gotoClacks();
        new ClacksListPage(mobileDriver)
                .gotoCreateClack();
        new ClacksCreatePage(mobileDriver)
                .send();
        new ClacksListPage(mobileDriver)
                .gotoUpdateFirstClack();
        new ClackUpdatePage(mobileDriver)
                .addFields()
                .send();
        new ClacksListPage(mobileDriver)
                .gotoDeleteFirstClack();
    }
}

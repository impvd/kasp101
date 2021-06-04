package com.example.kasp101

import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.screens.KScreen

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val simpleButton = KButton { withId(R.id.activity_main_simple_sample_button) }
}

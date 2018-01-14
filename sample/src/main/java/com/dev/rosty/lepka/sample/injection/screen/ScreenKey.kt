package com.dev.rosty.lepka.sample.injection.screen


import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ScreenKey(val value: ScreenType)
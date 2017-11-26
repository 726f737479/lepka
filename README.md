# Lepka
Lepka is a lightweight library that provides super easy interface for navigation within Android app.
Best used with **MVP** or **MVVM** architecture.

## Setup 
The principle of the library is built on the fact that the application has modules that unite the common logic and screens that implement this logic.

### Screens definition 
**Screen** is an abstraction that defines a specific logical part of the application. **Lepka** allows you to send additional data to the **Screens** that can then be extracted. Implementation base on **Fragments API**.
```kotlin
class RegistrationScreen : BaseScreen() {

    override fun getFragmentClass() = RegistrationFragment::class.java
}

class LoginScreen: BaseScreen() {

    override fun getFragmentClass() = LoginFragment::class.java
}

class FeedScreen : BaseScreen() {

    override fun getFragmentClass() = FeedFragment::class.java
}

class ProfileScreen(data: Data<User>) : BaseScreen(data) {

    override fun getFragmentClass() = ProfileFragment::class.java
}

class MessagesScreen : BaseScreen() {

    override fun getFragmentClass() = MessagesFragment::class.java
}

class ChatScreen(data: Data<Int>) : BaseScreen(data) {

    override fun getFragmentClass() = ChatFragment::class.java
}
```
### Modules definition 
The module is an entity that combines the logical all-encompassing parts of the application, in our case it's **Screens**. Based on the data that **Module**s provide, **Lepka** can decide whether to open a new activity or use current one to display the desired **Screen**.
```kotlin
class AuthorizationModule : BaseModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = AuthorizationActivity::class.java

    override fun canOpen(screen: Screen)
            = screen is RegistrationScreen || screen is LoginScreen
}

class HomeModule : BaseModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = HomeActivity::class.java

    override fun canOpen(screen: Screen)
            = screen is FeedScreen || screen is ProfileScreen || screen is MessagesScreen
}

class ChatModule : BaseModule() {

    override fun provideContainer()= R.id.container

    override fun getActivityClass() = ChatActivity::class.java

    override fun canOpen(screen: Screen)
            = screen is ChatScreen || screen is ProfileScreen
}
```
### Screens colision
Sometimes you may have a situation where several **Modules** can open the same screen, this problem can be resolved by overriding Priority for specific **Screen** in the desired **Module**. Default **Priority** of each screen is `Priority.HIGH`.
```kotlin
class ChatModule : BaseModule() {

    ...

    override fun getPriority(screen: Screen) 
            = if (screen is ProfileScreen) Priority.MEDIUM else Priority.HIGH
}
```

### Initialization 
**Lepka** must be initialized only once and application must have only single instance for it.
```kotlin
val modules = Arrays.asList<Module>(

        AuthorizationModule(),
        HomeModule(),
        ChatModule())

val lepka = LepkaBuilder()
        .setApplication(app)
        .setUseSupport(true)
        .registerModules(modules)
        .setEntryScreen(PickerScreen())
        .build()
```

## Usage
Switching between screens has never been so easy :)

### Naviagation
You just need to tell **Lipka** which command you want to execute, and it does everything itself. Available commands: `Forward(screen), Back()` soon appear: `ForwardPop(screen), BackTo(screen)`
```kotlin
lepka.execute(Forward(LoginScreen()))

lepka.execute(Forward(ProfileScreen(user)))

lepka.execute(Back(()))
```

### Retrieve screen data
When your **Screen** is opened you can retrieve all the data you sent with just one line of code.
```kotlin
val screenKey = KeysUtil.getScreenKey(fragmentArguments)
val user      = lepka.produceScreenData(screenKey)
```


License
=====================

<pre>
Copyright 2017 Rosty Vasiukov. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>

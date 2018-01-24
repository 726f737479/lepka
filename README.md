<img width=400 src="https://github.com/rostdev/lepka/blob/master/graphics/img_lepka_logo.jpg" />

**Lepka** is a lightweight library that provides super easy interface for navigating within an Android app.
Best used with **MVP** or **MVVM** architecture.

## Setup 
The principle of the library is built on the fact that the application has modules that unite the common logic and screens implementing this logic.

### Screens definition 
**Screen** is an abstraction that defines a specific part of the application logic. **Lepka** allows you to send additional data to **Screens** that can then be extracted. Implementation is based on **Fragments API**.
```kotlin
object LoginScreen : LepkaScreen(LoginFragment::class.java)

object NewsScreen : LepkaScreen(NewsFragment::class.java)

object MessagesScreen : LepkaScreen(MessagesFragment::class.java)

object AccountScreen : LepkaScreen(AccountFragment::class.java)

class PageScreen(title: String, count: Int) : LepkaScreen(PageFragment::class.java) {

    init {
        data.putString(EXTRA_PAGE_TITLE, title)
        data.putInt(EXTRA_PAGE_COUNT, count)
    }
}

class ChatScreen(title: String) : LepkaScreen(ChatFragment::class.java) {

    init { data.putString(EXTRA_CHAT_TITLE, title) }
}
```

### Modules definition 
**Module** is an entity that combines the logical all-encompassing parts of the application, in our case they are **Screens**. Based on the data that **Module**s provide, **Lepka** can decide whether to open a new activity or use current one to display the desired **Screen**.
```kotlin
class AuthorizationModule : LepkaModule() {

    override fun provideContainer() = R.id.container

    override fun getActivityClass() = AuthorizationActivity::class.java

    override fun canOpen(screen: Screen) = screen is LoginScreen
}

class HomeModule : LepkaModule() {

    ...

    override fun canOpen(screen: Screen) = screen is NewsScreen
            || screen is PageScreen
            || screen is MessagesScreen
            || screen is AccountScreen
}

class ChatModule : LepkaModule() {

    ...

    override fun canOpen(screen: Screen) = screen is ChatScreen
}
```
### Screens collision
Sometimes you may have a situation when several **Modules** can open the same screen, this problem can be resolved by overriding Priority for the specific **Screen** in the desired **Module**. Default **Priority** of each screen is `Priority.HIGH`.
```kotlin
class ChatModule : BaseModule() {

    ...

    override fun getPriority(screen: Screen) 
            = if (screen is ProfileScreen) Priority.MEDIUM else Priority.HIGH
}
```

### Initialization 
**Lepka** must be initialized only once and application must have only single instance of it.
```kotlin
val modules = Arrays.asList<Module>(

        AuthorizationModule(),
        HomeModule(),
        ChatModule())

val lepka = LepkaBuilder()
        .setApplication(app)
        .setUseSupport(true)
        .registerModules(modules)
        .setEntryScreen(AuthorizationScreen())
        .build()
```

## Usage
Switching between screens has never been so easy :)

### Naviagation
You just need to tell **Lepka** which command you want to execute, and it does everything else on its own. Available commands: `Forward(screen), Back(), ForwardPop(screen), BackTo(screen)`
```kotlin
lepka.execute(Command)
```

#### Forward
Using this **Command** you can navigate to next **Screen**. If current **Module** can open **Screen**, **Screen** will be opened in the same module. Otherwise **Screen** will be opened in the module that can do this.

#### Back
Using this **Command** you can navigate to the previous **Screen**. If current **Screen** is the last in a backstack of current **Module**, module will also be closed. If current **Module** is last in a backstack of application, application will be closed.

#### ForwardClear
Using this **Command** you can navigate to the next **Screen** and clear the backstack. If **Screen** can be opened in the same module, only current module's backstack will be cleeared. Otherwise all modules' backstacks will be cleared.

#### BackTo
Using this **Command** you can navigate back to the specified **Screen**. If current **Module** backstack doesn't containe specified **Screen**, current **Module** will be closed and so on until **Lepka** finds the right screen. If no previous modules contain this screen in the backstack, application will be closed.  

### Retrieve screen data
All data that you pass to a **Screen** is stored in the **Fragment** arguments.
```kotlin
val data = fragment.arguments
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


### 普通多模块项目（非组件化、插件化项目）

我们在[dagger.android多模块项目(一)](https://github.com/qq549631030/MultiModuleDagger3/blob/master/README.md)的基础上改造实现

Hilt 使用起来超级简单，不需要我们定义任何Component，只需要Module就可以了

我们把所有Component都删掉，只留下Module和Activity就可以了

先添加Hilt依赖

在项目build.gralde中加上

```groovy
buildscript {
    dependencies {
        classpath 'com.google.dagger:hilt-android-gradle-plugin:2.29-alpha'
    }
}
```

在所有使用到Hilt的模块的build.gralde中加上，这里有点比较奇怪按理hilt-android用api方法引入放在base模块就可以的，但是这样却会报错，也许是Hilt的一个bug吧。

```kotlin
apply plugin: 'com.android.application'
//apply plugin: 'com.android.library'

apply plugin: 'kotlin-kapt'
apply plugin: 'dagger.hilt.android.plugin'

dependencies {
    implementation "com.google.dagger:hilt-android:2.29-alpha"
    kapt "com.google.dagger:hilt-android-compiler:2.29-alpha"
}
```

app模块：

在AppApplication加上一个@HiltAndroidApp注解，注意不要加到BaseApplication上去了

```kotlin
@HiltAndroidApp
class AppApplication : BaseApplication() {
}
```

AppModule加上一个@InstallIn(ApplicationComponent::class) 这个代码AppModule为ApplicationComponent提供依赖

```kotlin
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @IntoSet
    @Provides
    fun provideString(): String {
        return "app"
    }
}
```

user,new模块:

UserModule、NewsModule加上一个@InstallIn(ActivityComponent::class) 这个代码AppModule为ActivityComponent提供依赖

```java
@Module
@InstallIn(ActivityComponent::class)
class NewsModule {

    @IntoSet
    @Provides
    fun provideString(): String {
        return "news"
    }
}

@Module
@InstallIn(ActivityComponent::class)
class UserModule {
    @IntoSet
    @Provides
    fun provideString(): String {
        return "user"
    }
}
```

UserActivity、NewsActivity加上一个@AndroidEntryPoint，这代表这个Activity需要Hint注入对象，注意，这个也不可以说加在BaseActivity上，这样做没用，只能加在最终页面上

```kotlin
@AndroidEntryPoint
class NewsActivity : BaseActivity() {

    @Inject
    lateinit var set: Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        text.text = set.toString()
    }
}
@AndroidEntryPoint
class UserActivity : BaseActivity() {

    @Inject
    lateinit var set: Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        text.text = set.toString()
    }
}
```

到这里Hilt注入就完成了，是不是超级简单

[代码地址](https://github.com/qq549631030/MultiModuleDagger5)
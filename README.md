# <p align="center"> Binding </p>

<p align="center">
一行代码实现 DataBinding 和 ViewBinding，欢迎 star<br/>
<p align="center">
<a href="https://github.com/hi-dhl"><img src="https://img.shields.io/badge/GitHub-HiDhl-4BC51D.svg?style=flat"></a>  <img src="https://img.shields.io/badge/language-kotlin-orange.svg"/> <img src="https://img.shields.io/badge/platform-android-lightgrey.svg"/>
</p>
</p>

<p align="center"> 如果图片无法查看，请点击这里查看 <a href="http://img.hi-dhl.com/viewBinding3.001.png"> 图例1</a> | <a href="http://img.hi-dhl.com/viewbinding.001.png"> 图例2</a></p>

<p align="center">
<image src="http://img.hi-dhl.com/viewBinding3.001.png" width = 600px/>
</p>

<p align="center">
<image src="http://img.hi-dhl.com/ViewBinding2.png" width = 600px/>
</p>



### 更新记录

**2020-12-15（V1.0.3）**

* 添加了 DataBinding 在 Dialog 中的使用，  `by databind(R.layout.dialog_data_binding)` 或者 `by databind(R.layout.dialog_data_binding, lifecycle)` 
* 添加 Activity 生命周期监听（当继承 Activity 且 Build.VERSION.SDK_INT < Build.VERSION_CODES.Q 时触发）

**2020-12-14:**

* Demo 增加 DataBinding 示例
* Demo 增加 ViewBinding 示例
* Demo 增加 kotlin-parcelize 示例

**2020-12-13（V1.0.1）**

* 添加了 ViewBinding 在 Dialog 中的使用，  `by viewbind()` 或者 `by viewbind(lifecycle)` 

**2020-12-12（V1.0.0）**

* 添加 DataBinding 和 ViewBinding 在 `Activity` 、`AppCompatActivity` 、`FragmentActivity` 、`Fragment` 中的使用
* 避免模板代码，只需要一行代码即可实现 DataBinding 或者 ViewBinding 
* 当生命周期处于 `onDestroyed()` 时会自动销毁数据

**如果这个仓库对你有帮助，请在仓库右上角帮我 star 一下，非常感谢。**

## Download

**Gradle**

将下列代码添加在模块级 `build.gradle` 文件中，并且需要开启 DataBinding 或者 ViewBinding

```
android {
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation 'com.hi-dhl:binding:1.0.2'
}
```


## Usage

* 在 `Activity` 、`AppCompatActivity` 、`FragmentActivity` 中使用，继承对应的类添加 `by viewbind()` 即可如下所示。

```
class MainActivity : AppCompatActivity() {

    // DataBinding
    val binding: ActivityMainBinding by databind(R.layout.activity_main)
    
    // ViewBinding
    val binding: ActivityMainBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            textView.setText("Binding")
        }
    }
}
```

* 在 `Fragment` 中使用方式如下所示。

```
class MainFragment : Fragment(R.layout.fragment_main) {
    
    // DataBinding
  	val binding: FragmentMainBinding by databind()
    
    // ViewBinding
  	 val binding: FragmentMainBinding by viewbind()
  
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply { textView.setText("Binding") }
    }
}
```

* 在 `Dialog` 中使用方式如下所示。

```
class AppDialog(context: Context) : Dialog(context, R.style.AppDialog) {

    // DataBinding
    val binding: DialogAppBinding by databind(R.layout.dialog_data_binding)
    
    // ViewBinding
    val binding: DialogAppBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { result.setText("DialogAppBinding") }
    }
}
```

或者添加生命周期监听

```
class AppDialog(context: Context,lifecycle: Lifecycle) : Dialog(context, R.style.AppDialog) {

    // DataBinding 监听生命周期
    val binding: DialogAppBinding by databind(R.layout.dialog_data_binding, lifecycle)
    
    // ViewBinding 监听生命周期
    val binding: DialogAppBinding by viewbind(lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { result.setText("DialogAppBinding") }
    }
}
```

### 联系我

* 个人微信：hi-dhl
* 公众号：ByteCode，包含 Jetpack ，Kotlin ，Android 10 系列源码，译文，LeetCode / 剑指 Offer / 多线程 / 国内外大厂算法题 等等一系列文章

<img src='http://cdn.51git.cn/2020-10-20-151047.png' width = 350px/>

---

最后推荐我一直在更新维护的项目和网站：

* 计划建立一个最全、最新的 AndroidX Jetpack 相关组件的实战项目 以及 相关组件原理分析文章，正在逐渐增加 Jetpack 新成员，仓库持续更新，欢迎前去查看：[AndroidX-Jetpack-Practice](https://github.com/hi-dhl/AndroidX-Jetpack-Practice)

* LeetCode / 剑指 offer / 国内外大厂面试题 / 多线程 题解，语言 Java 和 kotlin，包含多种解法、解题思路、时间复杂度、空间复杂度分析<br/>

    <image src="http://cdn.51git.cn/2020-10-04-16017884626310.jpg" width = "500px"/>
  
    * 剑指 offer 及国内外大厂面试题解：[在线阅读](https://offer.hi-dhl.com)
    * LeetCode 系列题解：[在线阅读](https://leetcode.hi-dhl.com)

* 最新 Android 10 源码分析系列文章，了解系统源码，不仅有助于分析问题，在面试过程中，对我们也是非常有帮助的，仓库持续更新，欢迎前去查看 [Android10-Source-Analysis](https://github.com/hi-dhl/Android10-Source-Analysis)

* 整理和翻译一系列精选国外的技术文章，每篇文章都会有**译者思考**部分，对原文的更加深入的解读，仓库持续更新，欢迎前去查看 [Technical-Article-Translation](https://github.com/hi-dhl/Technical-Article-Translation)

* 「为互联网人而设计，国内国外名站导航」涵括新闻、体育、生活、娱乐、设计、产品、运营、前端开发、Android 开发等等网址，欢迎前去查看 [为互联网人而设计导航网站](https://site.51git.cn)

**感谢**

中文：

感谢 [Simple one-liner ViewBinding in Fragments and Activities with Kotlin](https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c)  文章带来的思路，以及从 [Anko](https://github.com/Kotlin/anko) 、和 [ViewBindingDelegate](https://github.com/hoc081098/ViewBindingDelegate) 等等开源库中学习到技巧

English:

Thanks to the [Simple one-liner ViewBinding in Fragments and Activities with Kotlin](https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c) 、  [ViewBindingDelegate](https://github.com/hoc081098/ViewBindingDelegate) and [Anko](https://github.com/Kotlin/anko) ... open source project


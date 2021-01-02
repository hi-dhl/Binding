# <p align="center"> Binding </p>

<p align="center">
一行代码实现 DataBinding 和 ViewBinding，欢迎 star<br/>
One line of code implements DataBinding and ViewBinding. Welcome star
</p>

<p align="center">
    <a href="https://github.com/hi-dhl/Binding">English</a>&nbsp;
    ·
    &nbsp;<a href="https://github.com/hi-dhl/Binding/blob/main/doc/README_CN.md">中文</a>
</p>

<p align="center">
<a href="https://github.com/hi-dhl"><img src="https://img.shields.io/badge/GitHub-HiDhl-4BC51D.svg?style=flat"></a>  <img src="https://img.shields.io/badge/language-kotlin-orange.svg"/> <a href="https://bintray.com/hi-dhl/MeavenCenter/libraryName-binding/1.0.7/link"><img src="https://api.bintray.com/packages/hi-dhl/MeavenCenter/libraryName-binding/images/download.svg?version=1.0.7"/></a> <img src="https://img.shields.io/badge/platform-android-lightgrey.svg"/>
</p>

<p align="center"> 如果图片无法查看，请点击这里查看 <a href="http://img.hi-dhl.com/vbdb.png"> 图例1</a> | <a href="http://img.hi-dhl.com/ViewBidnding.png"> 图例2</a></p>

<p align="center">
<image src="http://img.hi-dhl.com/vbdb.png" width = 600px/>
</p>

<p align="center">
<image src="http://img.hi-dhl.com/ViewBidnding.png" width = 600px/>
</p>


## 关于 Binding

Binding 简化 DataBinding 和 ViewBinding 的使用， 只需要一行代码即可实现 DataBinding 和 ViewBinding。

Binding 未来的规划提供通用的 `findViewById` 解决方案，，因技术的迭代更新从 butterknife 、 DataBinding 、 Kotlin 合成方法（Synthetic 视图）到现在 ViewBinding ， 未来也有可能出现新的技术，无论技术怎么变化，只需要更新 Binding ，对外的使用保持不变。

Kotlin 合成方法（Synthetic 视图）比 ViewBinding 方便这么多，为什么会被 Google 抛弃掉，请查看这篇文章 [Kotlin 插件的落幕，ViewBinding 的崛起](https://mp.weixin.qq.com/s/FxrRyXp9-VDdv-mfkzsIsA)。

感谢小伙伴们的建议，目前 Binding 已经适配了大量的场景，同时也提供了很多 DataBinding 和 ViewBinding 实战案例，如果你在使用过程中遇到 Binding 不兼容的场景，欢迎提 issue，我会尽快解决。

**如果这个仓库对你有帮助，请在仓库右上角帮我 star 一下，非常感谢你的支持，同时也欢迎你提交 PR**  ❤️❤️❤️

**[Binding](https://github.com/hi-dhl/Binding) 具有以下优点：**

* 提供了很多实战案例包含 `Ativity` 、 `Fragment` 、 `Dialog` 、 `Adapter` 、 `include` 、 `merge` 、 `ViewStub` 、 `Navigation`  、 数据双向绑定 等等场景
* 简单的 API 只需要一行代码即可实现 DataBinding 或者 ViewBinding
* 支持在  `Activity` 、`AppCompatActivity` 、`FragmentActivity` 、`Fragment` 、`Dialog` 中的使用 DataBinding 或者 ViewBinding
* 支持在 `ListAdapter` 、 `PagedListAdapter` 、 `PagingDataAdapter` 、 `RecyclerView.Adapter` 中的使用 DataBinding 或者 ViewBinding
* 支持在 Navigaion Fragment 管理框架、 BottomSheetDialogFragment 等等场景中使用 DataBinding 和 ViewBinding
* 避免大量的模板代码
* 避免内存泄露，具有生命周期感知能力，当生命周期处于 `onDestroyed()` 时会自动销毁数据




## Download

**添加 jcenter**

将下列代码添加在 Project 级别的 `build.gradle` 文件中

```
allprojects {
    repositories {
        // 如果在国内建议添加 public，public 是 central 仓库 和 jcenter 仓库的聚合仓库
        maven { url "https://maven.aliyun.com/repository/public" }
        jcenter()
    }
}
```

**添加依赖**

将下列代码添加在模块级 `build.gradle` 文件中，并且需要开启 DataBinding 或者 ViewBinding

```
android {
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation 'com.hi-dhl:binding:1.0.7'
}
```


## Usage

在 Adapter 中使用 DataBinding 和 ViewBinding，只需要在 ViewHolder 中添加 `by viewbind()` 或者 `by databind()` 即可，示例如下所示，[查看详细示例](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/databind/list/ProductAdapter.kt)

```
class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    
    // 通过 DataBinding 绑定的 itemView
    val binding: RecycleItemProductBinding by databind()

    fun bindData(data: Product?, position: Int) {
        binding.apply {
            product = data
            executePendingBindings()
        }
    }
}

class ProductViewHolderHeader(view: View) : RecyclerView.ViewHolder(view) {

    // ViewBinding
    val binding: RecycleItemProductHeaderBinding by viewbind()

    fun bindData(data: Product?, position: Int) {
        binding.apply {
            name.text = "通过 ViewBinding 绑定的 head"
        }
    }
}
```


在 `Activity` 、`AppCompatActivity` 、`FragmentActivity` 中使用，添加 `by viewbind()` 或者 `by databind(R.layout.activity_main)` 即可，示例如下所示。

```
class MainActivity : AppCompatActivity() {

    // DataBinding
    val binding: ActivityMainBinding by databind(R.layout.activity_main)
    
    // ViewBinding
    val binding: ActivityMainBinding by viewbind()
}
```

在 `Fragment` 中提供了两种方式：
    
* 方式一：在 `onCreateView` 中使用，这种方式适用于所有使用 `Fragment` 的场景，[查看详细示例](https://github.com/hi-dhl/Binding/tree/main/app/src/main/java/com/hi/dhl/demo/binding/navigation)
* 方式二：在 `onViewCreated` 中使用，查看 [ViewBindFragment.kt](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/viewbind/ViewBindFragment.kt) 和 [DataBindRecycleFragment.kt](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/databind/list/DataBindRecycleFragment.kt)

**方式一：**

```
class FragmentNav1 : Fragment(R.layout.fragment_main) {
    
    // DataBinding
  	val binding: FragmentMainBinding by databind()
    
    // ViewBinding
  	 val binding: FragmentMainBinding by viewbind()
  
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}
```

**方式二，需要注意以下几点：**

* 在 `Navigaion Fragment` 和 `BottomSheetDialogFragment` 中仅能使用方式一，[查看 navigation](https://github.com/hi-dhl/Binding/tree/main/app/src/main/java/com/hi/dhl/demo/binding/navigation)
* 在其他 Fragment 场景中，如果使用 `方式二` 界面不显示，改用 `方式一` 即可解决

```
class FragmentNav1 : Fragment(R.layout.fragment_main) {
    
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

在 `Dialog` 中使用方式如下所示。

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

或者添加具有生命周期感知的 `Dialog`。

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

扩展方法，支持 DataBinding 初始化的时候绑定数据，感谢 `@br3ant` 贡献，[查看详细示例](https://github.com/hi-dhl/Binding/blob/054aa169d8dd39023be55be589b67e8097702bd1/app/src/main/java/com/hi/dhl/demo/binding/databind/DatBindActivity.kt#L28-L33)

```
val binding: ActivityDataBindBinding by databind(R.layout.activity_data_bind) {
    val account = Account()
    account.name = "test"
    this.account = account
}
```

### 混淆

```
-keepclassmembers class ** implements androidx.viewbinding.ViewBinding {
    public static ** bind(***);
    public static ** inflate(***);
}
```

### 更新记录

**2020-12-31**

* 增加 ViewStub 在 DataBinding 和 ViewBinding 中的使用案例，[查看详细示例](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/databind/BindViewStubActivity.kt)
* 增加 include 在 DataBinding 和 ViewBinding 中的使用案例，[DataBindIncludeActivity](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/databind/DataBindIncludeActivity.kt) 或者 [ViewBindIncludeActivity](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/viewbind/ViewBindIncludeActivity.kt)

**2020-12-28（V1.0.6）**

* 支持 Activity 和 Fragment 自动绑定 LifecycleOwner。[详见 issue](https://github.com/hi-dhl/Binding/issues/8)

**2020-12-21（V1.0.5）**

* 支持在 navigation fragment 中使用 DataBinding 和 ViewBinding，[查看详细示例](https://github.com/hi-dhl/Binding/tree/main/app/src/main/java/com/hi/dhl/demo/binding/navigation)

**2020-12-17（V1.0.4）**

* 支持所有与 RecyclerView.ViewHolder 相关的 Adapter（ListAdapter、PagingDataAdapter、RecyclerView.Adapter 等等）使用 DataBinding 和 ViewBinding，[查看详细示例](https://github.com/hi-dhl/Binding/blob/main/app/src/main/java/com/hi/dhl/demo/binding/databind/list/ProductAdapter.kt)

* 支持通过 `by databind` 初始化，同时可以绑定数据，感谢 `@br3ant` 贡献，[查看详细示例](https://github.com/hi-dhl/Binding/blob/054aa169d8dd39023be55be589b67e8097702bd1/app/src/main/java/com/hi/dhl/demo/binding/databind/DatBindActivity.kt#L28-L33)

**2020-12-15（V1.0.3）**

* 添加了 DataBinding 在 Dialog 中的使用，  `by databind(R.layout.dialog_data_binding)` 或者 `by databind(R.layout.dialog_data_binding, lifecycle)` 
* 处理了 `大于等于 Android 10.0` 和 `小于 Android 10.0` 生命周期问题，当处于 `onDestroyed()` 时会自动销毁数据
* 最低 SDK 版本降低至 14

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

感谢 [Simple one-liner ViewBinding in Fragments and Activities with Kotlin](https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c)  文章带来的思路，以及从 [Anko](https://github.com/Kotlin/anko) 、 [ViewBindingDelegate](https://github.com/hoc081098/ViewBindingDelegate) 和 jetpack 等等开源库中学习到技巧

English:

* the idea from [Simple one-liner ViewBinding in Fragments and Activities with Kotlin](https://medium.com/@Zhuinden/simple-one-liner-viewbinding-in-fragments-and-activities-with-kotlin-961430c6c07c)
* learn skills from open source libraries such as [Anko](https://github.com/Kotlin/anko) 、 [ViewBindingDelegate](https://github.com/hoc081098/ViewBindingDelegate) and jetpack



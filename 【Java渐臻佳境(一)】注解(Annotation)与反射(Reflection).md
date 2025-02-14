
<blockquote><font  face="Courier New, 宋体" color="#663300"><b>🔔建议:</b><font color="#cc3300"> 开发环境:  IEDA, 项目管理工具: Maven, 开发工具集: Jdk 1.8</font></font></blockquote>

<h1><font face="Courier new, 宋体">1️⃣引言</font></h1>

<h2><font face="courier new, 宋体" color="purple">1️⃣⏺️1️⃣摘要</font></h2>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓摘要:</b><br/>
<font color="#000">&nbsp;&nbsp;&nbsp;在Java语言中，本文详细介绍了Java中的注解和反射技术，包括它们的基本概念、使用场景、实现方式以及实际应用。注解是Java 1.5引入的一种元数据形式，用于为代码提供额外的信息，而反射则允许程序在运行时动态地获取类的信息并操作对象。文章通过多个示例，展示了如何定义和使用注解，以及如何通过反射获取类的结构、创建对象、调用方法和访问字段。此外，还探讨了反射的性能问题和如何通过关闭安全检查来提高性能。最后，文章通过ORM（对象关系映射）的示例，展示了注解和反射在实际开发中的应用。</font><br/>
</font></blockquot>

<hr />

<h2><font face="courier new, 宋体" color="purple">1️⃣⏺️2️⃣支持资源</font></h2>

<blockquote><font face="Courier New, 宋体" color="#009999"><b>🔋支持:</b><br/>
<font color="#993333">1.《【狂神说Java】注解和反射》【Bilibili】<a href="https://www.bilibili.com/video/BV1p4411P7V3" rel="noopener noreferrer">「AL」</a>〖✿✿✿〗<br/>
<font color="#3366cc"> AL: Access Link</font></font>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color="#003300"><b>🌌提供:</b><br/>
<font color="#cc3300" >1. <font color="#333399">annation_reflection</font>（项目: 本篇文章代码案例）<font color="#006600">【开源】</font><a href="https://github.com/AdnyWert/Java_Annation_Reflection.git">「AL」</a><font color="#ff0066">〖✿〗</font></font><br/>
</font></blockquote>


<hr />

<h2><font face="courier new, 宋体" color="purple">1️⃣⏺️3️⃣ 写作背景与目的</font></h2>

<font face="Courier New, 宋体" ><font color="#006600"><b>小蛙:</b></font><font color="#000000"> 为什么要学这部分内容?</font></font>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>(1)注解的广泛应用：</b><br/>
<font color="#000"><b>框架支持:</b> 许多现代Java框架（如Spring、Hibernate等）大量使用注解来简化配置和增强代码的可读性。例如，Spring框架通过@Controller、@Service等注解来管理Bean，Hibernate通过@Entity、@Table等注解来实现ORM映射。</font><br/>
<font color="#F00"><b>代码规范:</b></font> 注解可以帮助开发者更好地遵守代码规范，例如通过@Override注解确保方法覆盖了父类的方法，通过@Deprecated注解标记已废弃的方法或类。<br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>(2)反射的灵活性：</b><br/>
<font color="#000"><b>动态性:</b> 反射允许程序在运行时动态地获取类的信息，创建对象，调用方法，访问字段等。这种动态性使得代码更加灵活，能够适应不同的运行时环境。</font><br/>
<font color="#F00"><b>框架开发:</b></font> 许多框架（如Spring、MyBatis等）依赖反射机制来实现依赖注入、AOP（面向切面编程）、动态代理等功能。<br/>
<font color="#000"><b>开发工具:</b> IDE（如IntelliJ IDEA、Eclipse等）利用反射机制提供代码补全、重构、调试等功能。</font><br/>
</font></blockquote>


<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>(3)性能优化：</b><br/>
<font color="#000"><b>理解反射的性能问题:</b> 反射操作通常比直接调用方法或访问字段要慢得多，因此在性能敏感的应用中，了解反射的性能开销非常重要。</font><br/>
<font color="#000"><b>关闭安全检查:</b> 通过关闭安全检查（setAccessible(true)），可以显著提高反射的性能，同时需要理解其带来的安全风险。</font><br/>
</font></blockquote>


<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>(4)实际应用：</b><br/>
<font color="#000"><b>ORM框架:</b> 通过注解和反射，可以实现对象与数据库表的映射，简化数据库操作。</font><br/>
<font color="#000"><b>动态代理:</b> 利用反射可以实现动态代理，用于AOP、远程调用等场景。</font><br/>
<font color="#000"><b>序列化和反序列化:</b> 在对象的序列化和反序列化过程中，反射机制被用来动态访问对象的字段。</font><br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="green"><b>略过:</b> </font> 本篇文章由来，学习注解和反射技术对于理解和使用现代Java框架(SpringBoot)至关重要。注解提供了代码的元数据支持，使得代码更加清晰和规范；反射则提供了运行时动态操作类的能力，使得代码更加灵活和动态。掌握这些技术，不仅可以帮助你更好地使用现有的框架，还可以在需要时实现自己的框架或工具。</font>

<font face="Courier New, 宋体" color="#F80840"><b>💧珂珂:</b><font color="#E0220A"> 本文着重介绍注解和利用反射获取元数据，所涉及的框架中的注解并未过多介绍，道友若对某些方面感兴趣，可自行查阅相关文档，或与AI会话探讨相关知识。</font></font>


<hr /><hr />

<h1><font face="Courier new, 宋体">2️⃣Java注解技术</font></h1>

<h2><font face="courier new, 宋体" color="purple">2️⃣⏺️1️⃣注解的含义</font></h2>

<font face="Courier New, 宋体" ><font color="#006600"><b>小蛙:</b></font><font color="#000000"> Java注解是在Java 1.5（也称为JDK 5.0）中引入的新技术，它是Java中很重要的一部分。现在使用的很多框架，例如Spring Boot、Hibernate等，都大量使用了注解。注解不仅简化了代码，还增强了代码的可读性和可维护性。</font></font>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖注解的作用:</b><br/>
<font color="#000">不是程序本身，可以对程序作出解释。(这一点和注释(comment)没有什么区别)</font><br/>
<font color="#F00">可以被其他程序(如:javac编译器)读取.</font><br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖注解的格式:</b><br/>
<font color="#000">注解是以"@注解名"在代码中存在，还可以添加一些参数值，例如: SuppressWarnings("unchecked").</font><br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖注解的使用情景:</b><br/>
<font color="#000">可以附加在package、class、method、field等元素上方，相当于给他们添加了额外的辅助信息。</font><br/>
<font color="#F00">可以通过反射机制编程实现对这些元数据的访问。</font><br/>
</font></blockquote>

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> 在Java中，注解（Annotation）是一种特殊的标记，它提供了一种在代码中添加元数据（即关于代码的描述性信息）的方式。注解可以用于类、方法、字段、参数等程序(代码)元素上，为这些元素提供额外的信息或行为。</font></font>


<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖注解的定义:</b><br/><font color="#000000">&nbsp;&nbsp;注解本质上是一种<mark>特殊的接口</mark>，它使用<mark>@interface关键字</mark>定义。注解可以包含一些元素（类似于接口中的方法），这些元素可以有默认值。<br/></font></font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例2.1-1】<font color="black">定义一个简单的注解。</font></font></font>
```java
public @interface MyAnnotation {
    String name() default "defaultName";
    int[] value();
}
```

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> 这个注解MyAnnotation定义了两个元素name和value，value参数有默认值。</font></font>

<font face="Courier New, 宋体" color="#cc6600"><b>⚠️注:</b><font color="#663300"> 这个注解中两个元素是属性(参数、变量)并不是方法(函数)，虽然带有圆括号。</font></font>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 看到这里，你可能会疑惑，这注解是个啥呀，别急继续往下看，总有一点会让你豁然开朗。🐌</font>

<font face="Courier New, 宋体" ><font color="#006600"><b>小蛙:</b></font><font color="#000000"> 确实哈，为什么要用注解呀，我平时也不会自定义注解，但有些框架中会强制让你我使用注解，然而还不明白这些注解是如何被读取的。</font></font>

<hr />

<h2><font face="courier new, 宋体" color="purple">2️⃣⏺️2️⃣引入注解技术的原因</font></h2>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#cc3300" ><b>1. 提供元数据支持</b></font><br/>
<font color="#000"><b>含义:</b></font> 在Java中，注解可以用来描述代码的属性和行为，而这些信息在代码运行时可能需要被其他工具或框架读取。<br/>
<font color="#F03090"><b>举例:</b></font> 通过注解可以指定一个类是否是一个Spring Bean，或者一个方法是否是一个事务方法。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#cc3300" ><b>2. 减少配置文件的使用</b></font><br/>
<font color="#000"><b>含义:</b></font> <br/>
<font color="#F03090"><b>举例:</b></font> 在Java开发中，很多框架（如Spring、Hibernate等）需要大量的配置文件来定义组件的行为。 注解的引入使得这些配置可以通过代码直接声明，从而减少对XML等配置文件的依赖，简化配置过程。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#cc3300" ><b>3. 增强代码的可读性和可维护性</b></font><br/>
<font color="#000"><b>含义:</b> 注解以声明式的方式直接嵌入代码中，使得代码的意图更加明确。</font> <br/>
<font color="#F03090"><b>举例:</b></font> 通过@Override注解可以明确表示一个方法是覆盖父类方法的，这有助于开发者快速理解代码的结构和意图。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#cc3300" ><b>4. 提高开发效率</b></font><br/>
<font color="#000"><b>含义:</b> 注解可以被工具和框架自动处理，从而减少手动编写重复代码的工作量。</font> <br/>
<font color="#F03090"><b>举例:</b></font> 通过注解可以自动生成getter和setter方法，或者自动注册组件。<br/>
</font></blockquote>

<hr/>

<h2><font face="courier new, 宋体" color="purple">2️⃣⏺️3️⃣注解的作用</font></h2>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>☘️ 高级作用:</b></font><br/>
<font color="F80234"><b>元数据提供:</b></font> 注解可以为程序提供额外的元数据，这些元数据可以被编译器、运行时环境或其他工具读取和处理。 <br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>1. 编译时检查：</b></font><br/>
<font color="F80234"><b>语法检查:</b></font> 某些注解（如@Override、@Deprecated）可以帮助编译器检查代码的正确性，帮助开发者发现潜在的错误。例如，@Override注解可以确保一个方法确实是覆盖了父类的方法，如果方法签名不匹配，编译器会报错。 <br/>
<font color="#F03090"><b>代码规范检查:</b></font> 一些注解可以用于强制代码遵守特定的规范。例如，@CheckReturnValue注解可以提示开发者检查方法的返回值。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>2. 编译时代码生成：</b></font><br/>
<font color="F80234"><b>自动生成代码:</b></font> 通过注解处理器（Annotation Processor），可以在编译阶段根据注解生成额外的代码。例如，Lombok框架通过注解自动生成getter和setter方法，从而减少手动编写这些代码的工作量。 <br/>
<font color="#F03090"><b>生成配置文件(代码简化):</b></font> 某些注解可以用来生成配置文件或配置信息和样板代码，简化开发流程。例如，通过注解可以生成Spring的Bean配置信息，而无需手动编写XML配置文件。<br/>
<font color="#F06020"><b>功能增强:</b></font> 注解可以用于实现各种功能，如依赖注入、事务管理、日志记录等。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>3. 运行时动态处理：</b></font><br/>
<font color="F80234"><b>反射机制:</b></font> 注解可以通过反射在运行时被读取和处理，从而实现动态行为。例如，Spring框架通过注解（如@Controller、@Service）来识别和管理Bean，这些注解在运行时通过反射被解析，从而实现依赖注入等功能。 <br/>
<font color="#F03090"><b>行为增强:</b></font> 注解可以用来定义方法或类的行为。例如，@Transactional注解可以用来声明一个方法是事务性的，Spring框架在运行时会根据这个注解为方法添加事务管理逻辑。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>4. 文档说明：</b></font><br/>
<font color="F80234"><b>自动生成文档:</b></font> 注解可以用来生成API文档。例如，Javadoc注解（如@param、@return）可以被工具读取并生成详细的API文档。 <br/>
<font color="#F03090"><b>代码注释:</b></font> 注解可以作为一种特殊的注释，提供关于代码的额外信息。例如，@Deprecated注解可以用来标记一个方法或类已经被废弃，提醒开发者不要使用。<br/>
</font></blockquote>

<hr/>

<h2><font face="courier new, 宋体" color="purple">2️⃣⏺️4️⃣ 常见注解</font></h2>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 你或许会疑惑，这么多注解类型，咋可能学的透彻。想必你有这种感受，在学习Java基础知识时，你最多就会遇到@Override、@Deprecated这几个个注解；在学Android时你会遇到@NonNull、等常见注解；学到Java EE时用Servlet技术时，会用到@WebServlet注解。</font>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 由此可见，不同的开发场景下，会有一些特使的注解，也只有在这些特殊场景下这类注解才可用。那么 <b><mark>分类学习</mark></b> 就起到了用处，不同的开发环境下有些新学的注解需要额外关注和理解再加以积累。</font>


<font face="Courier New, 宋体" ><font color="#993366"><b>小夏:</b></font> <font color="#9900cc">Java中的注解可以按照其用途和功能分为以下几类，每类都有其特定的含义和典型代表：</font></font>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#cc3300" ><b>🌱注解分类:</b></font><br/>
<font color="#000"><b>1. 内置注解(Built-in Annotations):</b> 这些注解是Java语言(开发工具集)内置的，用于提供一些基本的功能支持。</font> <br/>
<font color="#F03090"><b>2. 元注解(Meta-Annotations):</b></font> 元注解是用于定义其他注解的注解，它们控制注解的行为和作用范围。一般地，显然 <mark>内置注解>元注解</mark> 涵盖的内容。<br/>
<font color="#000"><b>3. 框架注解(Framework Annotations):</b> 这些注解由各种框架(jar包集)提供，用于实现框架特定的功能。</font> <br/>
<font color="#F03090"><b>4. 测试注解(Testing Annotations):</b></font> 这些注解用于支持单元测试和集成测试。<br/>
<font color="#000"><b>5. 工具注解（Tool Annotations）:</b> 这些注解用于支持代码生成、文档生成等工具。 </font> <br/>
<font color="#F03090"><b>6. 自定义注解（Custom Annotations）:</b> 开发者可以根据需要定义自己的注解，用于特定的业务逻辑。</font><br/>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.1 内置注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#90F" ><b>1. 内置注解: </b></font><br/></font></blockquote>
<blockquote><font face="Courier New, 宋体" color='#000'>
<font color="#000"><b>@Override:</b> 用于标记方法覆盖父类方法。如果方法签名与父类不匹配，编译器会报错。</font> <br/>
<font color="#0184BC"><b>@Deprecated:</b></font> 用于标记某个类、方法或字段已被废弃，建议不要使用。但有的时候仍然可以使用。<br/>
<font color="#000"><b>@SuppressWarnings:</b> 用于告诉编译器忽略特定的警告，例如命名不规范时警告，在使用泛型时的警告。</font> <br/>
<font color="#0184BC"><b>@FunctionalInterface:</b></font> 用于标记一个接口为函数式接口（即只有一个抽象方法的接口）。<br/>
<font color="#000"><b>@SafeVarargs:</b> 用于标记方法或构造函数不会对其varargs参数执行不安全操作。</font> <br/>
</font></blockquote>

<font face="Courier New, 宋体" color="#cc6600"><b>⚠️注:</b><font color="#663300"> 现代的IDE编写的程序出现提示或警告，是无法避免的，你应该学会接受而不是直接抑制警告,这对有助于你扩展学习。</font></font>

<font face="Courier New, 宋体" ><font color="#1080F0">【源码2.4-1】<font color="black">@Overried的源码</font></font></font>

```java
package java.lang;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

<div><font face="Courier new, 宋体"  color="#000">
<font color="#6600cc">解说:</font> <br/>
<b>作用范围:</b> 仅适用于方法（ElementType.METHOD）。<br/>
<b>保留策略:</b> 仅在源代码中保留（RetentionPolicy.SOURCE），不会被编译器保留到 .class 文件中。<br/>
<b>是否有参:</b> 标记注解，不支持任何参数。<br/>
<b>编译时检查:</b> 帮助编译器验证方法是否正确覆盖了父类中的方法。<br/>
<b>代码可读性:</b> 明确表示方法的意图，提高代码的可读性和可维护性。<br/>
</font></div><br/>

<font face="Courier New, 宋体" ><font color="#1080F0">【源码2.4-2】<font color="black">@SuppressWarnings的源码</font></font></font>
```java
package java.lang;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value();
}
```

<div><font face="Courier new, 宋体"  color="#000">
<font color="#6600cc">解说:</font> <br/>
<b>作用范围:</b> 可以应用于多种程序元素，包括类、字段、方法、参数、构造函数和局部变量。<br/>
<b>保留策略:</b> 仅在源代码中保留（RetentionPolicy.SOURCE），不会被编译器保留到 .class 文件中。<br/>
<b>是否有参:</b> (成员 value)指定需要忽略的警告类型，每个类型用一个字符串表示。<br/>
<b>编译时忽略警告:</b> 告诉编译器忽略特定的警告，避免不必要的警告信息。<br/>
<b>不支持运行时反射:</b> 由于注解信息不会被包含在 .class 文件中，因此在运行时无法通过反射获取 @SuppressWarnings 注解的信息。<br/>
<b>代码可读性:</b> 明确表示开发者对特定警告的处理意图，提高代码的可读性和可维护性。<br/>
</font></div><br/>

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖描述:</b> @SuppressWarnings常见参数及用法<br/>
<font color="#000000">
1. "all": 忽略所有警告<br/>
2. "unchecked": 忽略未检查的类型转换警告<br/>
3. "deprecation": 忽略使用了废弃方法或类的警告<br/>
1. @SuppressWarnings("all")<br/>
2. @SuppressWarnings({"unchecked", "deprecation"})<br/>
</font>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.2 元注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F39" ><b>2. 元注解(Meta-Annotations): </b>作用负责注解其他的注解。</font><br/></font></blockquote>
<blockquote><font face="Courier New, 宋体" color='#000'>
<font color="#000"><b>@Target:</b> 指定注解可以应用的程序元素类型（如TYPE、METHOD、FIELD等）。</font> <br/>
<font color="#0184BC"><b>@Retention:</b> 定义注解的保留策略，即注解在什么阶段有效(生命周期)（SOURCE、CLASS、RUNTIME）。</font><br/>
<font color="#000"><b>@Documented:</b> 指示注解是否包含在JavaDoc文档中。</font> <br/>
<font color="#0184BC"><b>@Inherited:</b></font> 表示注解可以被子类继承。<br/>
<font color="#000"><b>@Repeatable:</b> 表示注解可以在同一目标上重复声明。</font> <br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#1080F0">【源码2.4-3】<font color="black">@Target的源码</font></font>

```java
package java.lang.annotation;

/**
 * @since 1.5
 * @jls 9.6.4.1 @Target
 * @jls 9.7.4 Where Annotations May Appear
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```

<font face="Courier New, 宋体" ><font color="#1080F0">【源码2.4-4】<font color="black">@Retention的源码</font></font>

<img src="https://i-blog.csdnimg.cn/direct/1bac53183b214cc5a3380a685855079e.png#pic_center" alt="🚀" title=' photo'>

<font face="Courier New, 宋体" color="#cc6600"><b>⚠️注:</b><font color="#663300"> 你会发现 <kbd>Ctrl</kbd>+<kbd>Retention</kbd> 无法查看源代码，但你又不甘心，为什么同样是annotation包的ElementType元素都可以查看，为什有些特殊的存在。有以下解决方案，(1) <kbd>Ctrl</kbd>+<kbd>annotation</kbd> 打开这个包的目录结构，在结构中查找对应的元素(类、接口...)。</font></font>


<blockquote><font face="Courier New, 宋体" color="#cc6600"><b>💡提示:</b><br/>
<font color="#663300"> 1. ElementType、RetentionPolicy是两个在元注解中几乎必须使用的元注解需要(依赖)的枚举类中不同的字段值，分别与@Target、@Retention配套使用。（了解这两个枚举类中对应的元素，可查看源码，一般IDE都支持查看源码, <kbd>Ctrl</kbd>+<code>元素名</code>(类名、变量名、函数名···)）</font><br/>
<font color="#66AA00">2. 查看相关的源码，可以加快学习效率，源码中有些标准的注释(解释)，可以帮助你理解代码的作用或功能。</font>
</font></blockquote>


```java
package java.lang.annotation;

public enum ElementType {
    /** Class, interface (including annotation type), or enum declaration */
    TYPE,
    /** Field declaration (includes enum constants) */
    FIELD,
    /** Method declaration */
    METHOD,
    /** Formal parameter declaration */
    PARAMETER,
    /** Constructor declaration */
    CONSTRUCTOR,
    /** Local variable declaration */
    LOCAL_VARIABLE,
    /** Annotation type declaration */
    ANNOTATION_TYPE,
    /** Package declaration */
    PACKAGE,
    /**
     * Type parameter declaration
     *
     * @since 1.8
     */
    TYPE_PARAMETER,
    /**
     * Use of a type
     *
     * @since 1.8
     */
    TYPE_USE
}
```

```java
package java.lang.annotation;

/**
 * @author  Joshua Bloch
 * @since 1.5
 */
public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,
    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,
    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}
```

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> "工欲善其事,必先利其器"，选择IDEA进行实验，创建一个项目如下。</font>

<img src="https://i-blog.csdnimg.cn/direct/a6e2aebcf71e4c999febf9af6770759a.png#pic_center" alt="🚀" title=' photo'>

<font face="Courier New, 宋体" ><font color="#F0700A">【演示2.4-1】<font color="black"> RetentionPolicy中SOURCE和CLASS的作用时间(生命周期)。</font></font></font>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> Java程序主要的运行流程: (1)源代码(.java) -> (2)‌源代码编译(.class) -> (3)运行(JVM环境)</font>

<img src="https://i-blog.csdnimg.cn/direct/456dc44b0bca49d591907f6a1bd46132.png#pic_center" alt="🚀" title=' photo'>


<div><font face="Courier new, 宋体"  color="#000">
<font color="#6600cc">解说:</font> <br/>
<b>注解的原型(定义)保留: </b> 由TargetRetentionAnnotation02注解的定义代码可知，在.java到.class阶段，CLASS并没有被移除。而用到该X02注解的Test类中的hi()方法的注解在.class阶段被移除了。在定义X02注解的代码部分中有CLASS元素，该元素是组成该X02注解的一部分，编译器并不能直接删除注解的组成部分，这样才能保证X02注解完整了，编译器方可处理用到该注解的代码元素部分。
</font></div>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.3 框架注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F08080" ><b>3. 框架注解(Framework Annotations): </b></font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(1) Servlet 3.0 </b></font><br/>
<font color="#000"><b>@WebServlet:</b> 用于定义Servlet。</font> <br/>
<font color="#0184BC"><b>@WebFilter:</b></font> 用于定义过滤器。<br/>
<font color="#000"><b>@WebListener:</b> 用于定义监听器。</font> <br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(2) Spring框架 </b></font><br/>
<font color="#000"><b>@Controller:</b> 用于标记控制器类，常与Spring MVC搭配使用。</font> <br/>
<font color="#0184BC"><b>@Service:</b></font> 用于标记服务层的类，处理业务逻辑。<br/>
<font color="#000"><b>@Repository:</b> 用于标记数据访问层的类，如DAO。</font> <br/>
<font color="#0184BC"><b>@Component:</b></font> 通用注解，用于标记Spring管理的Bean。<br/>
<font color="#000"><b>@Configuration:</b> 用于标记配置类，替代XML配置文件。</font> <br/>
<font color="#0184BC"><b>@Transactional:</b></font> 用于声明事务管理。。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(3) JPA / Hibernate </b></font><br/>
<font color="#000"><b>@Entity:</b> 标记一个类为JPA实体类。</font> <br/>
<font color="#0184BC"><b>@Table:</b></font> 指定实体类对应的数据库表名。<br/>
<font color="#000"><b>@Id:</b> 标记字段为实体类的主键。</font> <br/>
<font color="#0184BC"><b>@Column:</b></font> 指定字段对应的数据库列。<br/>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.4 测试注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#90F" ><b>4. 测试注解(Testing Annotations): </b></font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(1) JUnit 5</b></font><br/>
<font color="#000"><b>@Test:</b> 标记一个方法为测试方法。</font> <br/>
<font color="#0184BC"><b>@BeforeEach:</b></font> 在每个测试方法之前执行。<br/>
<font color="#000"><b>@AfterEach:</b> 在每个测试方法之后执行。</font> <br/>
<font color="#000"><b>@BeforeAll:</b> 在所有测试方法之前执行一次。</font> <br/>
<font color="#0184BC"><b>@AfterAll:</b></font> 在所有测试方法之后执行一次。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(2) Mockito</b></font><br/>
<font color="#000"><b>@Mock:</b> 用于标记Mock对象。</font> <br/>
<font color="#0184BC"><b>@InjectMocks:</b></font> 用于标记需要注入Mock对象的类。<br/>
<font color="#000"><b>@Captor:</b> 用于捕获参数值。<br/>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.5 工具注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#29F" ><b>5. 工具注解（Tool Annotations）: </b></font><br/>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(1) Lombok</b></font><br/>
<font color="#000"><b>@Data:</b> 自动生成getter、setter、<code>toString</code>、<code>equals</code>和<code>hashCode</code>方法。</font> <br/>
<font color="#0184BC"><b>@Getter、@Setter:</b></font> 分别生成getter和setter方法。<br/>
<font color="#000"><b>@NoArgsConstructor、@AllArgsConstructor:</b> 生成无参构造器和全参构造器。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#B33" ><b>(2) Jackson</b></font><br/>
<font color="#000"><b>@JsonInclude:</b> 指定JSON序列化时是否包含某些字段。</font> <br/>
<font color="#0184BC"><b>@JsonProperty:</b></font> 指定JSON字段的名称。<br/>
<font color="#000"><b>@JsonIgnore:</b> 忽略某个字段的序列化和反序列化。<br/>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">2.4.6 自定义注解</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#29F" ><b>6. 自定义注解（Custom Annotations）: </b></font><br/>
</font></blockquote>

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    String description();
}
```

<blockquote><font face="Courier New, 宋体" color="#990099"><b>✨总结:</b><br/>
<font color="#ff0066">1. Java中的注解类型丰富多样，每种类型都有其特定的用途。内置注解提供了基本功能支持，元注解用于定义注解的行为，框架注解用于实现框架特定的功能，测试注解用于支持测试工具，工具注解用于支持代码生成和文档生成，而自定义注解则为开发者提供了强大的扩展能力。</font><br/>
</font></blockquote>

<hr/>

<h2><font face="courier new, 宋体" color="purple">2️⃣⏺️5️⃣自定义注解</font></h2>

<h3><font face="Courier new, 宋体"  color="#000">2.5.1 自定义注解的一般格式</font></h3>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓介绍:</b><br/>
<font color="#336699">1. 使用@interface来自定义注解，自动继承了java.lang.annotation.Annotation接口。(并不能显示的继承)<br/></font>
</font></blockquote>


```java
package java.lang.annotation;

/**
 * @author  Josh Bloch
 * @since   1.5
 */
public interface Annotation {

    boolean equals(Object obj);

    String toString();

    Class<? extends Annotation> annotationType();
}
```

<font face="Courier New, 宋体" ><font color="#006600">【示例2.5-1】<font color="black"> 自定义注解一般样式。</font></font></font>

```java
package com.xiaxin.annotation;

import java.lang.annotation.*;
@GFAnnotation("color")
public class AGeneralFormat {
    @GFAnnotation(value = "season", code = {1,2,3,4})
    private String msg;

    // 2个及以上参数，必须指明参数再赋值

    @GFAnnotation(code = {0,1}, value = "boolean")
    public String getFormat(){ return null; }
}

/**
 * @author UiQi
 */
// 元注解, 标注自定义注解的 是否在javadoc中生成注释、子注解是否可继承、保留阶段(.java，.class, runtime)、作用对象(类名、字段名)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
// @interface + 自定义注解名 { 参数定义 }
@interface GFAnnotation {
    // 参数类型 + 参数名称() + [default + 默认值];
    int[] code() default {};
    String value();
}
```

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓介绍:</b><br/>
<font color="#369">1. @interface用来声明一个注解，格式<b> [public] @interface 注解名{ 定义元素 }</b>。<br/></font>
<font color="#000">2. 注解中的每一个元素(长得像方法，其实质是属性、字段、参数)，实际上是声明了一个配置参数。<br/></font>
<font color="#369">3. "方法"的名称就是参数的名称。(不能说成方法)。<br/></font>
<font color="#000">4. "返回值类型"就是参数的类型（返回值只能是基本类型Class、String、enum、int）。<br/></font>
<font color="#369">5. 可以通过<code>default</code>关键字来定义参数的默认值。<br/></font>
<font color="#000">6. 如果只有一个参数成员,一般参数名为value,在使用时可以省略该参数名而直接写数值(参数名必须是value才可省)。<br/></font>
<font color="#369">7. 有参数的注解，在使用该注解时必须要有值。通常在定义注解时，会设置参数类型的默认值，可以显示地省略赋值。<br/></font>
<font color="#000">8. 注解传递参数时需要加上参数名(2个及以上参数)，参数传递可以不按顺序，并不是所有参数都要传值(默认值可以不传)。<br/></font>
</font></blockquote>


<font face="Courier New, 宋体" ><font color="#006600">【示例2.5-2】<font color="black"> 自定义无参注解中的默认行为.</font></font></font>

```java
package com.xiaxin.annotation;


@NoParaAnnotation
public class BParameter {
    @NoParaAnnotation
    public String name;
    @NoParaAnnotation
    public void getParam() {}
}

/**
 * @author UiQi
 */
@interface NoParaAnnotation {

}
```

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> 在自定义注解时，如果不显式指定@Target和@Retention等元注解，注解的作用范围默认为ElementType.TYPE(按照编译器不同，可能是所有的范围)，生命周期默认为RetentionPolicy.CLASS(按照编译器不同，可能是所有的范围)。为了更好地控制注解的行为，建议根据实际需求显式指定这些元注解。</font></font>

<font face="Courier New, 宋体" ><font color="#006600">【示例2.4-3】<font color="black"> 自定义有参注解中的默认行为.</font></font></font>

```java
package com.xiaxin.annotation;

import java.lang.annotation.*;

@HPAnnotation
public class CHavaParameter {
    @HPAnnotation("Information")
    private String msg;
    @HPAnnotation()
    public String getMsg(){
        return msg;
    }
}

/**
 * @author UiQi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@interface HPAnnotation {
    String value() default "";
}
```

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> 使用注解不进行传值时有无括号，没啥影响。</font></font>

<font face="Courier New, 宋体" color="#cc6600"><b>🎀经验:</b><font color="#c668dd"> 建议在有参数的注解中，使用括号，尽管有默认值；在无参数的注解中，不使用括号。</font></font>

<hr /><hr/>

<h1><font face="Courier new, 宋体">3️⃣Java反射技术</font></h1>

<h2><font face="courier new, 宋体" color="purple">3️⃣⏺️1️⃣静态语言与动态语言</font></h2>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>1. 含义：</b></font><br/>
<font color="F80234"><b>静态语言（Static Language）:</b></font> 静态语言在编译时进行类型检查，变量的类型在编译时就已经确定，且在运行时不可更改。特点: 类型安全、性能较高、编译时错误检查严格。<br/>
<font color="#F03090"><b>动态语言（Dynamic Language）:</b></font> 动态语言在运行时进行类型检查，变量的类型在运行时确定，且可以在运行时更改。特点: 灵活性高、开发速度快、适合快速迭代。<br/>
</font></blockquote>

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> <mark>动态语言</mark>是一类在运行时可以改变其结构(逻辑)的语言，例如新的函数、对象、甚至代码块可以被引进，已有的函数可以被删除或者是其他结构上的变化。简而言之就是在运行代码期间可以改变代码的结构。<mark>静态语言</mark>与动态语言相对应，运行是结构不可变的语言。</font></font>


<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> Java不是动态语言，但Java可以称为"准动态语言"。即Java有一定的动态性。可以利用<mark>反射机制</mark>获得类似动态语言的特性。Java的动态性让编程的时候更加灵活!</font>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>2. 语言代表：</b></font><br/></font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>静态语言:</b></font><br/>
<b>Java：</b>广泛用于企业级应用、Android开发。<br/>
<b>C/C++：</b>用于系统编程、嵌入式开发、高性能应用。<br/>
<b>C#：</b>用于Windows应用、游戏开发（Unity）。<br/>
<b>Kotlin：</b>用于Android开发，是Java的现代替代品。<br/>
<b>Go：</b>用于并发编程、云服务、微服务。<br/>
<b>Rust：</b>用于系统编程、安全性和并发性要求高的场景。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F03090" ><b>动态语言:</b></font><br/>
<b>Python：</b>广泛用于数据科学、机器学习、Web开发（Django、Flask）。<br/>
<b>JavaScript：</b>用于Web开发（前端和后端，如Node.js）。<br/>
<b>Ruby：</b>用于Web开发（Ruby on Rails）。<br/>
<b>PHP：</b>用于Web开发，尤其是服务器端脚本。<br/>
<b>Perl：</b>用于文本处理、系统管理脚本。<br/>
<b>Lua：</b>用于嵌入式脚本、游戏开发。<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.1-1】<font color="black"> 动态语言编程案例。</font></font></font>


```javascript
function dynamic(x,  y) {
	var structedCode = "var result = x + y;" ;
	eval(structedCode);
	console.log(result);
}
dynamic(4 , -1);
```

```python
def dynamic(x: int, y: int):
    structCode = "x + y"
    result = eval(structCode)
    print(result)
    
if __name__ == '__main__':
    dynamic(4, -1)
```


<font face="Courier New, 宋体" ><font color="#F0700A">【演示3.1-1】<font color="black">动态语言编程案例。</font></font></font>

<img src="https://i-blog.csdnimg.cn/direct/0866b204897a4bf6a14541a72eb48da7.gif#pic_center" alt="🚀" title=' gif'>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>3. 区别：</b></font><br/></font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#000" ><b>类型检查时间：</b></font><br/>
<font color="F80234"><b>静态语言:</b></font>  在编译时进行类型检查，编译器会检查变量的类型是否匹配。<br/>
<font color="#F03090"><b>动态语言:</b></font>  在运行时进行类型检查，类型错误在运行时才会被发现。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#000" ><b>性能：</b></font><br/>
<font color="F80234"><b>静态语言:</b></font>  通常性能更高，因为编译器可以在编译时进行优化。<br/>
<font color="#F03090"><b>动态语言:</b></font>  性能相对较低，因为类型检查和优化在运行时进行。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#000" ><b>开发效率：</b></font><br/>
<font color="F80234"><b>静态语言:</b></font>  开发效率可能较低，因为需要显式声明类型，编译时间可能较长。<br/>
<font color="#F03090"><b>动态语言:</b></font>  开发效率较高，因为不需要显式声明类型，代码更简洁，迭代速度快。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#000" ><b>错误检测：</b></font><br/>
<font color="F80234"><b>静态语言:</b></font>  编译器可以在编译时发现类型错误，减少运行时错误。 <br/>
<font color="#F03090"><b>动态语言:</b></font>  类型错误通常在运行时发现，可能需要更多的测试来确保代码的正确性。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#000" ><b>灵活性：</b></font><br/>
<font color="F80234"><b>静态语言:</b></font>  类型系统严格，灵活性较低。 <br/>
<font color="#F03090"><b>动态语言:</b></font>  类型系统灵活，可以在运行时动态更改变量类型。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>4. 联系：</b></font><br/>
<font color="F80234"><b>混合使用:</b></font>  许多现代项目中会混合使用静态语言和动态语言。例如，使用Python进行快速开发，然后用C++进行性能优化。<br/>
<font color="#F03090"><b>互操作性:</b></font>  一些语言提供了与其他语言的互操作性。例如，Python可以通过Cython调用C代码，Java可以通过JNI调用C/C++代码。 <br/>
<font color="F80234"><b>工具链:</b></font>  静态语言和动态语言都可以使用现代的开发工具链，如IDE、调试器、测试框架等。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>5. 使用场景：</b></font><br/></font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>静态语言:</b></font><br/>
<b>企业级应用：</b>Java、C#等静态语言适合大型、复杂的企业级应用，因为它们提供了类型安全和性能优势。<br/>
<b>系统编程：</b>C/C++、Rust等静态语言适合系统编程、嵌入式开发和高性能应用。<br/>
<b>并发编程：</b>Go、Rust等静态语言提供了强大的并发支持，适合并发编程和微服务架构。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F03090" ><b>动态语言:</b></font><br/>
<b>Web开发：</b>Python（Django、Flask）、JavaScript（Node.js）、Ruby on Rails等动态语言适合快速开发Web应用。<br/>
<b>数据科学和机器学习：</b>Python是数据科学和机器学习领域的首选语言，因为其丰富的库和框架。<br/>
<b>脚本和自动化：</b>Python、Perl等动态语言适合编写脚本和自动化任务。<br/>
<b>快速原型开发：</b>动态语言适合快速迭代和原型开发，因为它们可以快速实现功能并进行测试。<br/>
</font></blockquote>

<hr />

<h2><font face="courier new, 宋体" color="purple">3️⃣⏺️2️⃣Java Reflection Overview</font></h2>


<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>1.定义：</b></font><br/>
<font color="F80234"><b>Java反射(Reflection):</b></font> 是一种强大的技术，允许程序在运行时动态地获取类的信息，借助Reflection API对类进行任意操作，即操作对象的内部属性及方法，如创建实例、调用方法、访问字段等。反射机制极大地提高了Java程序的灵活性和动态性，但也带来了性能和安全方面的挑战。<br/>
</font></blockquote>

<blockquote><center><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b></b></font>
<font color="F80234"><b>Class c = Class.forName("com.example.MyClass")</b></font><br/>
</font></center></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>2. 反射的核心API类: </b>反射机制主要依赖于java.lang.reflect包中的类和接口，这些核心类包括：</font> <br/>
<font color="F80234"><b>java.lang.Class:</b></font> 表示类或接口本身，用于获取类的名称、构造方法、方法、字段等信息。<br/>
<font color="#000"><b>Constructor:</b></font>  表示类的构造方法，可以用来创建类的实例。<br/>
<font color="#000"><b>Method:</b></font>  表示类的方法，可以用来调用对象的方法。<br/>
<font color="#000"><b>Field:</b></font>  表示类的字段（属性），可以直接操作对象的属性。<br/>
</font></blockquote>


<img src="https://i-blog.csdnimg.cn/direct/902a40c62f74414e85e032a6702f2aec.png" alt="🚀" title='Copy'>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓介绍运行机制:</b><br/>
<font color="#336699">加载完类之后，在堆内存的方法区中就存在了一个Class类型的对象(一个类只有一个Class对象)，这个对象就包涵了<mark>完整的类的结构信息</mark>。</font><br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 我们可以通过这个对象看到类的结构。这个对象就像一面镜子，通过这个镜子看到类的结构，所以我们形象称之为<b>反射</b>。</font>

<blockquote ><font face="Courier New, 宋体" color="#003399">
<b>📓类的正常执行方式:</b><br/>
 <b><font color="#336699"><b>引入需要的"包类"名称</b> -> 通过new实例化 -> <mark>获得实例化对象</mark></font></b><br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#003399">
<b>📓反射执行方式:</b><br/>
 <b><font color="#336699"><b>实例化对象</b> -> getClass()方法 -> <mark>获得完整的"包类"名称</mark></font></b><br/>
</font></blockquote>


<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>3. 反射的基本操作：</b></font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>(1) 获取Class对象：</b>获取Class对象是反射操作的第一步。Java提供了多种方式来获取Class对象：</font><br/>
<font color="#000"><b>通过类名:</b></font> Class<?> clazz = Class.forName("com.example.MyClass");。<br/>
<font color="#000"><b>通过实例:</b></font>  Class<?> clazz = myObject.getClass();。<br/>
<font color="#000"><b>通过类字面量:</b></font>  Class<?> clazz = MyClass.class;。<br/>
<font color="#000"><b>内置基本数据类型:</b></font>  直接使用类名.Type。<br/>
<font color="#000"><b>类加载器:</b></font> 利用ClassLoader。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F03090" ><b>(2)  创建实例：</b>通过反射创建类的实例：</font><br/>
<font color="#000">使用无参构造函数:</b></font> MyClass myObject = (MyClass) clazz.newInstance();。<br/>
<font color="#000"><b>使用指定构造函数:</b></font>  Constructor<?> constructor = clazz.getConstructor(String.class);。<br/>
</font></blockquote>


<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F03090" ><b>(3) 访问字段：</b>通过反射获取和设置类的字段：</font><br/>
<font color="#000"><b>获取字段:</b></font> Field field = clazz.getDeclaredField("name");。<br/>
<font color="#000"><b>设置字段值:</b></font>  field.set(myObject, "newName");。<br/>
<font color="#000"><b>获取字段值:</b></font>  String name = (String) field.get(myObject);。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>(4)调用方法：</b>通过反射调用类的方法:</font><br/>
<font color="#000"><b>获取方法:</b></font> Class<?> Method method = clazz.getDeclaredMethod("myMethod", String.class);。<br/>
<font color="#000"><b>调用方法:</b></font>  Class<?> Object result = method.invoke(myObject, "parameter");。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>4. 反射的应用场景：</b></font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#9900F0" ><b></b></font>
<font color="#000"><b>框架开发:</b></font> Spring、Hibernate等框架大量使用反射机制来实现依赖注入、面向切面编程(AOP)等功能。<br/>
<font color="#000"><b>动态代理:</b></font>  Java的动态代理机制依赖于反射，用于AOP和远程调用。<br/>
<font color="#000"><b>开发工具和IDE:</b></font>  利用反射机制提供代码补全、重构等功能。<br/>
<font color="#000"><b>序列化和反序列化:</b></font>  在对象的序列化和反序列化过程中，反射机制被用来动态访问对象的字段。<br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#F08080"><b>✒️Java反射机制提供的功能:</b><br/>
<font color="#000">► 在运行时判断任意一个对象所属的类<br/></font>
<font color="#000">► 在运行时构造任何一个类的对象<br/></font>
<font color="#000">► 在运行时判断任何一个类所具有的成员变量和方法<br/></font>
<font color="#000">► 在运行时获取泛型信息 <br/></font>
<font color="#000">► 在运行时调用任意一个对象的成员变量和方法<br/></font>
<font color="#000">► 在运行时处理注解 <br/></font>
<font color="#000">► 生成动态代理 <br/></font>
<font color="#000">► ......<br/></font>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>5. 反射的优缺点:</b></font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>优点:</b></font><br/>
<font color="#000"><b>动态性:</b></font> 反射允许在运行时动态操作类，极大地提高了代码的灵活性。<br/>
<font color="#000"><b>灵活性:</b></font>  通过反射，可以编写更加通用和可扩展的代码。<br/>
<font color="#000"><b>框架支持:</b></font>  许多流行的Java框架和库都依赖反射机制。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#A010AA" ><b>缺点:</b></font><br/>
<font color="#000"><b>性能开销:</b></font> 反射操作相比直接调用，性能开销较大。<br/>
<font color="#000"><b>安全风险:</b></font>  反射可以绕过Java的访问控制机制，可能带来安全风险。<br/>
<font color="#000"><b>代码可读性:</b></font>  反射使代码变得更加复杂和难以理解。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#0184BC" ><b>6. 反射的性能与限制:</b></font><br/>
虽然反射提供了极大的灵活性，但它也带来了一些性能和安全方面的问题。<br/>
反射操作通常比直接调用方法或访问字段要慢得多，因此在性能敏感的应用中应谨慎使用。<br/>
此外，<b>反射可以突破Java的访问权限控制</b>，这在一定程度上降低了程序的安全性。
</font></blockquote>

<hr />

<h2><font face="courier new, 宋体" color="purple">3️⃣⏺️3️⃣ Class类介绍</font></h2>

<h3><font face="Courier new, 宋体"  color="#000">3.3.1 Class类</font></h3>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>理解Class类:</b><br/>
<font color="#000">Class可理解为湖面，湖面上倒映了一些景物，可获知岸上真实事物的一些信息。<br/>
某个类的属性、方法和构造器、某个类到底实现了那些接口。<br/>
对每个类而言，JRE都为其保留了一个不变的Class类型的对象。<br/>
一个Class对象包含了特定某个结构(Class/interface/enum/annotation/primitive type/void/[])的有关信息。
</font>
</font></blockquote>

<img src="https://i-blog.csdnimg.cn/direct/fa00af6cad6c44cd8feda4512d3abeaa.png#pic_center" alt="🚀" title=' photo' width="600px">

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F30" ><b>Class类介绍：</b></font><br/>
<b>>.</b> Class是一个继承Object类的类<br/>
<b>>.</b> Class对象只能由系统创建<br/>
<b>>.</b> 一个加载的类在JVM中只能有一个Class实例<br/>
<b>>.</b> 一个Class对象对应的是一个加载到JVM中的一个.class文件<br/>
<b>>.</b> 每个类的实例都会记得自己是由那个Class实例所生成<br/>
<b>>.</b> 通过Class可以完整地得到一个类中的所有被加载的结构<br/>
<b>>.</b> Class类是Reflection的根源，针对任何你想动态加载、运行的类，为有先获得相应的Class对象。<br/>
</font></blockquote>

<hr/>
<h3><font face="Courier new, 宋体"  color="#000">3.3.2 Class类的常用方法</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F30" ><b>Class类的常用方法：</b></font><br/>
</font></blockquote>

<table>
<tr>
	<th><font face='Courier New, 宋体' size=3'>方法名</font></th>
	<th><font face='Courier New, 宋体' size=3'>功能说明</font></th>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>static Class forName(String name)</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回指定类名的Class对象</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Object newInstance()</font></td>
	<td><font face='Courier New, 宋体' size=3'>调用缺省(无参)构造函数，返回Class对象的一个实例</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>String getName()</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回此Class对象锁表示的实体(类，接口，数组类或void)的名称</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Class getSuperClass()</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回当前对象的父类的Class对象</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Class[] getInterfaces()</font></td>
	<td><font face='Courier New, 宋体' size=3'>获取当前Class对象的接口。</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>ClassLoader[] getClassLoader()</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回该类的加载器</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Constructor[] getConstructors()</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回一个Method对象，此对象的形参类型为paramType</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Method getMothed(String name, Class... T)</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回一个Method对象，此对象的形参类型为paramType</font></td>
</tr>
<tr>
	<td  align='left'><font face='Courier New, 宋体' size=3'>Field[]</font></td>
	<td><font face='Courier New, 宋体' size=3'>返回Field对象的一个数组</font></td>
</tr>
</table>

<hr/>
<h3><font face="Courier new, 宋体"  color="#000">3.3.3 Object、Class、自定义类的联系</font></h3>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>1. Object类:</b><br/>
<font color="#000"><mark>Object是Java中所有类的根类</mark>，即所有类（包括自定义类）都直接或间接继承自Object类。Object类提供了许多基础方法，这些方法可以被所有对象使用。<br/></font>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#A829F2" ><b>Object类的主要方法:</b></font><br/>
<b>toString():</b> 返回对象的字符串表示。<br/>
<b>equals(Object obj):</b>比较两个对象是否相等。<br/>
<b>hashCode():</b> 返回对象的哈希码值。<br/>
<mark><b>getClass():</b></mark> 返回对象的Class对象。<br/>
<b>finalize():</b> 在对象被垃圾回收之前执行清理操作。<br/>
<b>clone():</b> 创建对象的副本。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color="#E33" ><b>public final Class getClass()</b></font></blockquote>

<font face="Courier new, 宋体"  color="#000"><font color="#6600cc">解说:</font> 以上方法的返回值类型是一个Class类，此类是Java反射的源头，实际上所谓的反射从程序的运行结果来看也很好理解，即: 可以通过对象反射推断出类的名称。</font></font>

<font face="Courier New, 宋体" color="#FF5500"><b>👁️‍🗨️惑:</b><font color="#FF3300"> 是否有这样的疑惑基本类Object中的getClass()类的返回类型是Class类，但是Object是Class的父类，这个父类有用了子类对象，岂不是有矛盾。若有疑惑请仔细查阅相关资料，以解惑。</font></font>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>2. Class类:</b><br/>
<font color="#000">Class类是Java反射机制的核心，它表示一个类的类型信息。<mark>每个类在运行时都有一个对应的Class对象</mark>，这个对象包含了类的元数据，如类名、字段、方法等。<br/></font>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#A829F2" ><b>Class类的主要方法：</b></font><br/>
<b>getName():</b> 返回类的全限定名。<br/>
<b>getFields():</b> 返回类的所有公共字段。<br/>
<b>getMethods():</b> 返回类的所有公共方法。。<br/>
<b>getConstructors():</b> 返回类的所有公共构造方法。<br/>
<b>newInstance():</b> 创建类的新实例（已弃用，推荐使用Constructor对象的newInstance方法）。<br/>
<b>isAssignableFrom(Class<?> cls):</b> 判断当前类是否是参数类的父类或接口。<br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>3. 自定义类:</b><br/>
<font color="#000">自定义类是开发者根据具体需求定义的类。自定义类继承自Object类，并且在运行时，每个自定义类都有一个对应的Class对象。<br/></font>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#A829F2" ><b>自定义类的主要特性：</b></font><br/>
<b>继承自Object类:</b> 所有自定义类都继承自Object类，因此可以使用Object类提供的方法。<br/>
<b>具有Class对象:</b> 每个自定义类在运行时都有一个对应的Class对象。<br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>4. 三者之间的关系:</b><br/></font></blockquote>


<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F30" ><b>Object类与自定义类：</b></font><br/>
<b>>.</b> 所有自定义类都继承自Object类。<br/>
<b>>.</b> 自定义类可以通过Object类的方法进行通用操作，如toString()、equals()等。<br/>
<b>>.</b> 自定义类可以通过getClass()方法获取其Class对象。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F30" ><b>Class类与自定义类：</b></font><br/>
<b>>.</b> 每个自定义类在运行时都有一个对应的Class对象。<br/>
<b>>.</b> Class对象包含了自定义类的元数据，如类名、字段、方法等。<br/>
<b>>.</b> 通过Class对象，可以动态地创建自定义类的实例、调用方法、访问字段等。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F30" ><b>Object类与Class类：</b></font><br/>
<b>>.</b> Object类提供了getClass()方法，用于获取对象的Class对象。<br/>
<b>>.</b> Class类是Object类的一个实例(具体的一个功能类)，用于表示类的类型信息。<br/>
</font></blockquote>


<font face="Courier New, 宋体" ><font color="#006600">【示例3.3-1】<font color="black"> 以下是一个简单的示例，展示Object、Class和自定义类之间的关系：</font></font></font>

```java
package com.xiaxin.annotation;

import java.lang.reflect.Method;


public class Test02 {
    public static void main(String[] args) throws Exception {
        // 创建自定义类的实例
        MyClass myObject = new MyClass("UiQi");

        // 使用Object类的方法
        System.out.println(myObject.toString()); // 输出对象的字符串表示
        System.out.println(myObject.equals(new MyClass("UiQi"))); // 比较两个对象是否相等

        // 获取Class对象
        Class<?> clazz = myObject.getClass();
        System.out.println(clazz.getName()); // 输出类的全限定名

        // 使用Class对象创建实例
        MyClass anotherObject = (MyClass) clazz.getDeclaredConstructor(String.class).newInstance("Alice");
        System.out.println(anotherObject.toString()); // 输出新创建对象的字符串表示

        // 使用Class对象调用方法
        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        setNameMethod.invoke(anotherObject, "Bob");
        System.out.println(anotherObject.toString()); // 输出修改后的对象字符串表示
    }
}

class MyClass {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{name='" + name + "'}";
    }
}
```
```bash
MyClass{name='UiQi'}
false
com.xiaxin.reflection.example01.MyClass
MyClass{name='Alice'}
MyClass{name='Bob'}
```

<blockquote><font face="Courier New, 宋体" color="#990099"><b>✨总结:</b><br/>
<font color="#ff0066">1. Object类：所有类的根类，提供了通用方法。 </font><br/>
<font color="#ff0066">2. Class类：表示类的类型信息，提供了反射机制的核心功能。 </font><br/>
<font color="#ff0066">3. 自定义类：继承自Object类，具有Class对象，可以通过反射机制动态操作。 </font><br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 理解Object、Class和自定义类之间的关系，有助于更好地掌握Java的面向对象特性和反射机制，从而编写更加灵活和强大的Java程序。</font>

<hr/>
<h3><font face="Courier new, 宋体"  color="#000">3.3.4 获取Class 对象的几种方式</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>获取Class对象：</b>获取Class对象是反射操作的第一步。Java提供了多种方式来获取Class对象：</font><br/>
<font color="#000"><b>通过类名:</b></font> Class<?> clazz = Class.forName("com.example.MyClass");。<br/>
<font color="#000"><b>通过实例:</b></font>  Class<?> clazz = myObject.getClass();。<br/>
<font color="#000"><b>通过类字面量:</b></font>  Class<?> clazz = MyClass.class;。<br/>
<font color="#000"><b>内置基本数据类型:</b></font>  直接使用类名.Type。<br/>
<font color="#000"><b>类加载器:</b></font> 利用ClassLoader。<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.3-2】<font color="black"> 获取Class对象的几种方式</font></font></font>

```java
package com.xiaxin.reflection;

public class Test01 {
    // 通过反射获取类的Class对象

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 通过类名
        // 已知一个类的全类名，且该类在类的路径下，可以通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
        Class c1 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class c2 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class c3 = Class.forName("com.xiaxin.reflection.example01.Animal");
        Class s1 = Class.forName("java.lang.String");
        System.out.println(c1 + "   " + s1);

        // 一个类在内存中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println("hashCode: c1:"+ c1.hashCode() + "\n"
                + "hashCode: c2:"+ c2.hashCode() + "\n"
                + "hashCode: c3:"+ c3.hashCode() + "\n"
                + "hashCode: s1:"+ s1.hashCode());

        // 2. 通过实例
        // 已知某个类的实例，调用该实例的getClass()方法获取Class对象
        // 注意: Class类的一个实例，与Animal类的实例
        Class cc1 = c1.getClass();
        Class e2 = new Animal().getClass();
        Class s2 = "UiQi".getClass();
        System.out.println(cc1 + "   " + s2);
        System.out.println("hashCode: cc1:"+ c1.hashCode() + "\n"
                + "hashCode: e2:"+ e2.hashCode() + "\n"
                + "hashCode: s1:"+ s2.hashCode());

        // 3. 类字面量
        // 若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最佳
        Class w1 = Animal.class;
        Class w2 = Animal.class;
        Class s3 = String.class;
        System.out.println(w1 + "   " + s3);
        System.out.println("hashCode: w1:"+ w1.hashCode() + "\n"
                + "hashCode: w2:"+ w2.hashCode() + "\n"
                + "hashCode: s3:"+ s3.hashCode());

        // 4. 内置的基本类型中的包装类有Type属性
        // Boolean、Byte、Character、Short、Integer、Long、Float、Double、Void
        Class i1 = Integer.TYPE;
        Class i2 = Integer.TYPE;
        Class x1 = Void.TYPE;
        System.out.println(i1 + "   " + i2 + "       " + x1);
        System.out.println("hashCode: i1:"+ i1.hashCode() + "\n"
                + "hashCode: i2:"+ i2.hashCode() + "\n"
                + "hashCode: x1:"+ x1.hashCode() + "\n");

        // 5. 获取父类的Class类型
        Class t1 = Tom.class;
        Class f1 = t1.getSuperclass();
        System.out.println(t1 + "   " + f1);
    }
}

// 实体类 pojo，entity，bean，dto

class Animal {
    private String name;
    private int age;

    public Animal() {
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Tom extends Animal {}
```
```bash
class com.xiaxin.reflection.example01.Animal   class java.lang.String
hashCode: c1:460141958
hashCode: c2:460141958
hashCode: c3:460141958
hashCode: s1:1163157884
class java.lang.Class   class java.lang.String
hashCode: cc1:1610427175
hashCode: e2:460141958
hashCode: s1:1163157884
class com.xiaxin.reflection.example01.Animal   class java.lang.String
hashCode: w1:460141958
hashCode: w2:460141958
hashCode: s3:1163157884
int   int       void
hashCode: i1:1956725890
hashCode: i2:1956725890
hashCode: x1:356573597

class com.xiaxin.reflection.example01.Tom   class com.xiaxin.reflection.example01.Animal
```

<hr/>
<h3><font face="Courier new, 宋体"  color="#000">3.3.5 类型的Class对象</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>Class对象：</b>以下类型可以有Class对象：</font><br/>
<b>class:</b> 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类<br/>
<b>interface:</b> 接口<br/>
<b>[]:</b> 数组<br/>
<b>enum:</b> 枚举<br/>
<b>annotation:</b> 注解@interface<br/>
<b>primitive type:</b> 基本数据类型<br/>
<b>void:</b><br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.3-3】<font color="black"> 不同数据类型的Class对象。</font></font></font>

```java
package com.xiaxin.reflection;

import java.lang.annotation.ElementType;

// 类型的Class对象
public class Test02 {
    public static void main(String[] args) {
        Class c1 = Object.class;        // 类
        Class c2 = Comparable.class;    // 接口
        Class c3 = String[].class;      // 一维数组
        Class c4 = int[][].class;       // 二维数组
        Class c5 = Override.class;      // 注解
        Class c6 = ElementType.class;   // 枚举
        Class c7 = Integer.class;       // 基本包装类
        Class c8 = void.class;          // void
        Class c9 = Class.class;         // Class
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println();

        // 只要元素类型和维度一样，那么就是同一个 Class对象
        int[] arr1 = new int[5];
        int[] arr2 = new int[10];
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());
        System.out.println(arr1.getClass().hashCode());
        System.out.println(arr2.getClass().hashCode());
    }
}
```
```bash
class java.lang.Object
interface java.lang.Comparable
class [Ljava.lang.String;
class [[I
interface java.lang.Override
class java.lang.annotation.ElementType
class java.lang.Integer
void
class java.lang.Class

460141958
1163157884
1956725890
1956725890
```

<font face="Courier New, 宋体" color="#F30"><b>📋结论:</b><font color="#c668dd"> 只要元素类型和维度一样，那么就是同一个 Class对象</font></font>

<hr />

<h2><font face="courier new, 宋体" color="purple">3️⃣⏺️4️⃣类的运行机制</font></h2>

<h3><font face="Courier new, 宋体"  color="#000">3.4.1 类加载至内存原理分析</font></h3>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> Java程序运行在内存中，分为不同的几个大区域，方便管理不同代码段，以便程序更好的运行，使得计算机性能得到充分利用。</font>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>JVM内存区域分类：</b> 堆、栈、方法区(堆). (JDK 8之前)</font><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>堆：</b> </font><br/>
<b>(1)线程共享:</b> 可以被所有的线程共享，不会存放别的对象引用<br/>
<b>(2)存放类型:</b> 存放 new 的对象和数组<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>栈：</b> </font><br/>
<b>(1)存放类型:</b> 存放基本变量类型(会包含这个基本类型的具体数值)<br/>
<b>(2)引用对象:</b> 引用对象的变量(会存放这个引用在堆里面的具体地址)<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>方法区：</b> </font><br/>
<b>(1)线程共享:</b> 可以被所有线程共享<br/>
<b>(2)存储内容:</b> 包含了所有的class和static变量<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 当程序主动使用了某个类时，如果该类还为被加载到内存中，则系统会通过如下三个步骤来对该类进行初始化。</font>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#206399" ><b>类的加载过程：</b> </font><br/>
<b>(1)类加载(Load):</b> 将类的.class文件读入内存，并为之创建一个java.lang.Class对象。此过程由类加载器完成。<br/>
<b>(2)类链接(Link):</b> 将二进制数据合并到JRE中。<br/>
<b>(3)类的初始化(Initialize):</b> JVM负责对类进行初始化。<br/>
</font></blockquote>


<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>加载：</b> </font><br/>
<b></b> 将class文件字节码内容加载到内存中，斌对这些静态数据转换成方法区的运行时数据结构，然后生成一个代表这个类的java.lang.Class对象。<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>链接：</b> 将Java类的二进制代码合并到JVM的运行状态之间的过程。</font><br/>
<b>>.验证:</b> 确保加载的类信息符合JVM规范，没有安全方面的问题<br/>
<b>>.准备:</b> 正式为类变量(static)分配内存并设置类变量默认初始值阶段，这些内存都将在方法区中进行分配。<br/>
<b>>.解析:</b> 虚拟机常量池内的符号引用(常量名)替换为直接引用(地址)的过程<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="#F80234" ><b>初始化：</b> </font><br/>
<b>>.</b> 执行类构造器 &lt;clinit>()方法的过程。类构造器&lt;clinit>()方法是由编译器自动搜集类中所有类变量的赋值动作和静态代码块中的语句合并产生。(类构造器是构造类信息的，不是构造该类对象的构造器)<br/>
<b>>.</b> 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。<br/>
<b>>.</b> 虚拟机会保证一个类的&lt;clinit>()方法在多线程环境中被正确加锁和同步。<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="green"><b>略过:</b> </font> 之后会出一篇介绍Java程序运行在内存的原理分析。</font>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-1】<font color="black"> 类加载到内存的阶段分析。</font></font></font>


```java
package com.xiaxin.reflection;

public class Test03 {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println("code = " + A.getCode() + ", " + "state = " + obj.getState());
    }
    /*
    * 1. A类 加载至内存, 会产生一个类对应的 Class 对象
    * 2. 链接，链接结束后 code = 0
    * 3. 初始化
    * <clint>() {
    *   System.out.println("A Class Static Block, code ?= " + "在定义之前不可读取值");
    *   code = 100;
    *   code = 10;
    * }
    * 4. 在运行其余
    * */
}

class A {
    static {
        System.out.println("A Class Static Block, code ?= " + "在定义之前不可读取值");
        code = 100;
    }
    private static int code = 10;
    private int state = -1;

    public A() {
        System.out.println("A Constructor Block, code = " + code);
        state = 0;
    }

    public static int getCode() {
        return code;
    }

    public int getState() {
        return state;
    }
}
```
```bash
A Class Static Block, code ?= 在定义之前不可读取值
A Constructor Block, code = 10
code = 10, state = 0
```



<hr />

<h3><font face="Courier new, 宋体"  color="#000">3.4.2 类的加载时机（初始化）</font></h3>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 类的初始化(加载)有哪些方式可以触发？</font>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>类的主动引用（一定会发生类的初始化）：</b> </font><br/>
<b>(1):</b> 当虚拟机启动，先初始化 main() 方法所在类<br/>
<b>(2):</b> new 一个类的对象<br/>
<b>(3):</b> 调用类的静态成员（除了final常量）和静态方法<br/>
<b>(4):</b> 使用java.lang.reflect包中的方法对类进行反射调用<br/>
<b>(5):</b> 当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类<br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>类的被动引用（不会发生类的初始化）：</b> </font><br/>
<b>(1):</b> 当访问一个静态域时，只有真正声明这个域的类才会被初始化。如，当通过子类引用父类的静态变量，不会导致子类初始化。<br/>
<b>(2):</b> 通过数组定义类引用，不会触发此类的初始化<br/>
<b>(3):</b> 引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-2】<font color="black"> 类是否加载到内存。</font></font></font>
```java
package com.xiaxin.reflection.example01;

// 类在什么时候会被初始化
public class Test04 {
    static {
        System.out.println("Test04 static block");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 类初始化(加载)的方式

        // 1. 主动引用
        // Son son = new Son();

        // 2. 反射产生主动引用
        // Class.forName("com.xiaxin.reflection.example01.Son");

        // 不会产生类的引用(加载)的方式
        // 1. 调用父类的静态属性或方法
        // System.out.println(Son.fa);

        // 2. 创建一个类型的数组
        // Son[] sons = new Son[10];

        // 3. 调用常量
         System.out.println(Son.CODE);
    }
}

class Father {
    static int fa = -1;
    static {
        System.out.println("Father static block");
    }
}

class Son extends Father {
    static {
        System.out.println("Son static block");
        code = 100;
    }
    static int code = 10;
    static final int CODE = 1;
}
```

<hr />
<h3><font face="Courier new, 宋体"  color="#000">3.4.3 类加载器</font></h3>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 类加载器是什么呢，有啥作用呢？</font>

<img src="https://i-blog.csdnimg.cn/direct/62e3e08df8bc4fd08e4195efcabf5f4c.png#pic_center" alt="🚀" title=' photo'>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>类加载器：</b> </font><br/>
<b>类加载器的作用:</b> 将.class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后在堆中生成一个代表这个类的java.lang.Class对象，作为方法区中数据的访问入口。<br/>
<b>类缓存:</b> 标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器中，它将维持加载(缓存)一段时间。不过JVM垃圾回收机制可以回收这些CLass对象。<br/>
</font></blockquote>

<img src="https://i-blog.csdnimg.cn/direct/84361cfb3fb84f45bdff207f0835c5b1.png#pic_center" alt="🚀" title=' photo' width='400px'>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>JVM规范定义了如下类型的类的加载器：</b> </font><br/>
<b>引导类加载器:</b> 用C++编写的，是JVM自带的类加载器，负责Java平台核心库，用来装载核心类库(rt.jar)。该加载器无法直接获取。<br/>
<b>扩展下载器:</b> 负责jre.lib.ext目录下的jar包或 -D java.ext.dirs指定目录下的jar包工作库。<br/>
<b>系统类加载器:</b> 复制java -claaapath 或 -D java.class.path所指定的目录下的类与jar包装入工作，是最常用的加载器。<br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> JRE中核心的类库rt.jar，平时Java基础知识会学到的内容。</font>

<img src="https://i-blog.csdnimg.cn/direct/11a855163bf6491cb570f10046ce1f02.png#pic_center" alt="🚀" title=' photo'>

<font face="Courier New, 宋体" ><font color="#000000"><b>mome:</b> 使用zip或RAR软件可以查看.jar压缩文件中的内容。</font>

<img src="https://i-blog.csdnimg.cn/direct/5aaccdf64a5a4c0b861d6efef15fd061.png#pic_center" alt="🚀" title=' photo'>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-3】<font color="black"> 不同级别的类库加载到内存的方式。</font></font></font>

```java
package com.xiaxin.reflection;

/**
 * ========================================================
 * @Project: annotation_reflection
 * @Version: 1.0.0
 * @class : com.xiaxin.reflection.Test05
 * @Author : SiTi
 * @Time : 2025-02-14 14:11:57
 * @IDE: IntelliJ IDEA 2024.1 - Interpreter: JDK 1.8
 * @Describe :
 * ========================================================
 */

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载的父类加载器 --> 扩展加载器
        ClassLoader parentClassLoader = systemClassLoader.getParent();
        System.out.println(parentClassLoader);

        // 获取扩展加载器的父类加载器 --> 根加载器(C/C++)
        ClassLoader classLoader = parentClassLoader.getParent();
        System.out.println(classLoader);

        // 测试当前类是那个加载器加载的
        ClassLoader classLoader1 = Class.forName("com.xiaxin.reflection.example01.Test05").getClassLoader();
        System.out.println(classLoader1);

        // 测试 JDK 内置的类(核心类库)是谁加载的
        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);

        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        // 双亲委派机制规定，当一个类加载器加载某个类时，它会先将请求委派给父类加载器，只有当父类加载器无法加载该类时，才会尝试自己加载。
    }
}
```

```bash
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$ExtClassLoader@1b6d3586
null
sun.misc.Launcher$AppClassLoader@18b4aac2
null
D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\charsets.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\deploy.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\javaws.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\jce.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\jfr.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\jsse.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\management-agent.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\plugin.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\resources.jar;D:\NUC\CST_23\Java\jdk1.8.0_201\jre\lib\rt.jar;C:\POPG\java\extension\annotation\target\classes;D:\IDE\IntelliJIDEA\IntelliJ IDEA 2024.2.3\lib\idea_rt.jar
```

<hr />
<h3><font face="Courier new, 宋体"  color="#000">3.4.4 获取类运行时的结构</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>通过反射获取运行时类的完整结构：</b> Field、Method、Constructor、SuperCalss、interface、Annotation。</font><br/>
<b>>. 实现的全部接口</b><br/>
<b>>. 所继承的父类</b> <br/>
<b>>. 全部的构造器</b><br/>
<b>>. 全部的方法</b> <br/>
<b>>. 全部的Field</b><br/>
<b>>. 注解。。。</b> <br/>
</font></blockquote>


<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-4】<font color="black"> Class 对象所常用的方法。</font></font></font>

```java
package com.xiaxin.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获得类的信息

public class Test06 {
    public static void main(String[] args) {
        Class c1 = CustomTest.class;

        // 1. 获得类的名称
        System.out.println("====== 1. 获得类的名称 ======");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        // 2. 获得类的属性
        System.out.println("======= 2. 获得类的属性 ======");
        // (1) 获得 本类及其父类所有 公有属性
        Field[] pFields = c1.getFields();
        for (Field pField : pFields) {
            System.out.println("getFields:" + pField + ": " + pField.getName());
        }
        // (2) 获得 本类所有属性
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("getDeclaredFields: " + field + ": " + field.getName());
        }
        // (3) 获得 指定属性(本类及其父类 所有 公有属性): 不存在或者权限不符合或参数不匹配  均会抛出异常
        try {
            Field pfield = c1.getField("D");
            System.out.println("getField: " + pfield + " -> " + pfield.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得 指定属性(本类所有范围类的属性): 不存在或参数不匹配 会抛出异常
        try {
            Field field = c1.getDeclaredField("msg");
            System.out.println("getDeclaredField: " + field + " -> " + field.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        // 3. 获得类的方法
        System.out.println("===== 3. 获得类的方法 =====");
        // (1) 获得 本类及其父类所有的 public 方法
        Method[] pMethods = c1.getMethods();
        for (Method pMethod : pMethods) {
            System.out.println("getMethods: " + pMethod + ": " + pMethod.getName());
        }
        // (2) 获得 本类所有的方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("getDeclaredMethods: " + method + ": " + method.getName());
        }

        // 注意重载，通过参数判断
        // (3) 获得指定方法 (本类及其父类 所有 公有方法): 不存在或者权限不符合 均会抛出异常
        try {
            Method pMethod = c1.getMethod("getMsg");
            System.out.println("getMethod: " + pMethod + " -> " + pMethod.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得指定方法 (本类所有方法): 不存在  会抛出异常
        try {
            Method method = c1.getDeclaredMethod("setMsg", String.class);
            System.out.println("getDeclaredMethod: " + method + " : " + method.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 4. 获得构造器
        // (1) 获得 本类所有 public 构造器
        System.out.println("===== 4. 获得构造器 =====");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor pConstructor : constructors) {
            System.out.println("getConstructors: " + pConstructor + ": " + pConstructor.getName());
        }

        // (2) 获得 本类所有 构造器
        Constructor[] pConstructors = c1.getDeclaredConstructors();
        for (Constructor pConstructor : pConstructors) {
            System.out.println("getDeclaredConstructors: " + pConstructor + ": " + pConstructor.getName());
        }

        // (3) 获得 指定的构造器 (公有类型)
        try {
            Constructor pConstructor = c1.getConstructor();
            System.out.println("getConstructor: " + pConstructor + " -> " + pConstructor.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // (4) 获得 指定构造器(所有类型)
        try {
            Constructor constructor = c1.getDeclaredConstructor(String.class, boolean.class);
            System.out.println("getDeclaredConstructor: " + constructor + " -> " + constructor.getName());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomBasic {
    private String A;
    protected String B;
    static final String C = "TRUE";
    public String D;

    public CustomBasic() {}

    public String getA() {
        return A;
    }
    protected void setA(String A) {
        this.A = A;
    }
}

class CustomTest extends CustomBasic {
    private String msg = "UiQi";
    protected boolean state;
    static char VERSION = 'A';
    public int code;

    public CustomTest() {}
    public CustomTest(boolean state) {
        this.state = state;
    }
    private CustomTest(String msg, boolean state) {
        this.msg = msg;
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}
```

```bash
====== 1. 获得类的名称 ======
com.xiaxin.reflection.example01.CustomTest
CustomTest
======= 2. 获得类的属性 ======
getFields:public int com.xiaxin.reflection.example01.CustomTest.code: code
getFields:public java.lang.String com.xiaxin.reflection.example01.CustomBasic.D: D
getDeclaredFields: private java.lang.String com.xiaxin.reflection.example01.CustomTest.msg: msg
getDeclaredFields: protected boolean com.xiaxin.reflection.example01.CustomTest.state: state
getDeclaredFields: static char com.xiaxin.reflection.example01.CustomTest.VERSION: VERSION
getDeclaredFields: public int com.xiaxin.reflection.example01.CustomTest.code: code
getField: public java.lang.String com.xiaxin.reflection.example01.CustomBasic.D -> D
getDeclaredField: private java.lang.String com.xiaxin.reflection.example01.CustomTest.msg -> msg
===== 3. 获得类的方法 =====
getMethods: public java.lang.String com.xiaxin.reflection.example01.CustomTest.getMsg(): getMsg
getMethods: public java.lang.String com.xiaxin.reflection.example01.CustomBasic.getA(): getA
getMethods: public final void java.lang.Object.wait() throws java.lang.InterruptedException: wait
getMethods: public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException: wait
getMethods: public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException: wait
getMethods: public boolean java.lang.Object.equals(java.lang.Object): equals
getMethods: public java.lang.String java.lang.Object.toString(): toString
getMethods: public native int java.lang.Object.hashCode(): hashCode
getMethods: public final native java.lang.Class java.lang.Object.getClass(): getClass
getMethods: public final native void java.lang.Object.notify(): notify
getMethods: public final native void java.lang.Object.notifyAll(): notifyAll
getDeclaredMethods: public java.lang.String com.xiaxin.reflection.example01.CustomTest.getMsg(): getMsg
getDeclaredMethods: private void com.xiaxin.reflection.example01.CustomTest.setMsg(java.lang.String): setMsg
getMethod: public java.lang.String com.xiaxin.reflection.example01.CustomTest.getMsg() -> getMsg
getDeclaredMethod: private void com.xiaxin.reflection.example01.CustomTest.setMsg(java.lang.String) : setMsg
===== 4. 获得构造器 =====
getConstructors: public com.xiaxin.reflection.example01.CustomTest(boolean): com.xiaxin.reflection.example01.CustomTest
getConstructors: public com.xiaxin.reflection.example01.CustomTest(): com.xiaxin.reflection.example01.CustomTest
getDeclaredConstructors: private com.xiaxin.reflection.example01.CustomTest(java.lang.String,boolean): com.xiaxin.reflection.example01.CustomTest
getDeclaredConstructors: public com.xiaxin.reflection.example01.CustomTest(boolean): com.xiaxin.reflection.example01.CustomTest
getDeclaredConstructors: public com.xiaxin.reflection.example01.CustomTest(): com.xiaxin.reflection.example01.CustomTest
getConstructor: public com.xiaxin.reflection.example01.CustomTest() -> com.xiaxin.reflection.example01.CustomTest
getDeclaredConstructor: private com.xiaxin.reflection.example01.CustomTest(java.lang.String,boolean) -> com.xiaxin.reflection.example01.CustomTest
```

<hr />
<h3><font face="Courier new, 宋体"  color="#000">3.4.5 动态创建对象执行的方式</font></h3>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>(1) 无参构造器:</b> 调用Class对象的newInstance()方法</font><br/>
<b>1) 类必须有一个无参数的构造器(构造方法)</b><br/>
<b>2) 类的构造器的访问权限需要适应</b><br/>
</font></blockquote>

<blockquote><font face="Courier New, 宋体" color='#000'><font color="F80234" ><b>(2)有参构造器：</b> </font><br/>
<b>1) 通过Class类的getDeclaredConstructor(Class ...parameterTypes)取得本类的指定形参类型的构造器</b><br/>
<b>2) 向构造器的形参中传递一个对象数组进去，里面包含了构造器中所需的各个参数</b><br/>
<b>3) 通过Constructor实例化对象</b><br/>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-5】<font color="black"> 通过反射动态创建对象的方式及其访问元素和方法。</font></font></font>

```java
package com.xiaxin.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过反射动态创建对象
public class Test07 {
    public static void main(String[] args) throws NoSuchMethodException {
        // 1. 获得 Class 对象
        Class c = null;
        try {
            c = Class.forName("com.xiaxin.reflection.example01.CustomTest");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
            // 会中断 Java 代码的运行
        }

        // 2. 构造一个对象
        CustomTest obj;
        try {
            // (1) 调用了类的无参构造器
             obj = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 扩展 权限修饰 访问范围
        // 同一个 包目录下(同一个目录中) 可以直接访问 所有 的类 (public、package权限)
        // protected 修饰的元素: 子类也可以访问
        System.out.println("父类 package static C: " + CustomTest.C);
        System.out.println("父类 protected B: " + obj.B);

		// (2) 通过构造器创建对象

        Constructor constructor = null;
        try {
            constructor = c.getDeclaredConstructor(boolean.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        CustomTest obj2 = null;

        try {
            obj2 = (CustomTest) constructor.newInstance(true);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println(obj2.state);

        // 3. 通过反射调用普通方法

        // (1) 创建一个对象
        CustomTest obj3 = null;
        try {
            obj3 = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // (2) 通过反射获取一个 方法

        // a. private 方法 无法 激活
        // 通过 关闭安全检查机制即可
        Method setMsg = c.getDeclaredMethod("setMsg", String.class);

        try {
            // 激活执行方法
            setMsg.setAccessible(true);
            setMsg.invoke(obj3, "滴答");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // b. public 方法
        Method getMsg = c.getDeclaredMethod("getMsg");
        try {
            // 激活执行方法
            Object o = getMsg.invoke(obj3);
            System.out.println(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


        // 4. 通过反射操作属性
        // (1) 生成一个对象
        CustomTest obj4 = null;
        try {
            obj4 = (CustomTest) c.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // (2) 获取属性
        Field state = null;
        Field msg = null;
        try {
            state = c.getDeclaredField("state");
            msg = c.getDeclaredField("msg");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        // (3) 设置属性的值
        try {
            state.set(obj4, true);
            // 不能直接操作私有属性，无法设置 private 限定的属性 ?? 可以
            // 设置为 true， 关闭安全检查， 就可以设置 私有属性的值了
            msg.setAccessible(true);
            msg.set(obj4, "AiMi");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        System.out.println(obj4.state);
        System.out.println(obj4.getMsg());
    }
}
```

```bash
父类 package static C: TRUE
父类 protected B: null
true
滴答
true
AiMi
```

<blockquote ><font face="Courier New, 宋体" color="#0184BC"><b>📖调用指定方法:</b> 通过反射，调用类中的方法，通过Method类完成<br/>
<font color="#000">① 通过Class 类的getMethod(String name, Class...parameterTypes)方法获得一个Method对象，并设置此方法操作时所需要的参数类型。<br/>
② 之后使用Object invoke(Object obj, Object[] args)进行调用，并向方法中传递要设置的obj对象的参数信息。</font>
</font></blockquote>

<img src="https://i-blog.csdnimg.cn/direct/14e4ddf2fb7f442e8f68050f36ca1dac.png#pic_center" alt="🚀" title=' photo'>
<br/>

<blockquote ><font face="Courier New, 宋体" color="#000"> <font color="#0184BC"><b>📖 Object invoke(Object obj, Object ...args)</b> </font><br/>
<b>>. </b>Object 对应原方法的返回值，若原方法无返回值，此时返回null.<br/>
<b>>. </b>若原方法无静态方法，此时形参Object obj可可视为 null.<br/>
<b>>. </b>若原方法形参列表为空,则Objec[] args为null或不写.<br/>
<b>>. </b>若原方法声明为private，则需要再调用此invoke()方法前，显示调用方法对象的setAccessible(true)方法，将可访问private的方法。<br/>
</font></blockquote>

<blockquote ><font face="Courier New, 宋体" color="#000"> <font color="#0184BC"><b>📖 setAccessible(boolean flag)</b> </font><br/>
<b>>. </b>Method、Field和Constructor对象都有setAccessible()方法.<br/>
<b>>. </b>setAccessible()作用是启动和禁用访问安全检查的开关.<br/>
<b>>. </b>参数为true则指示反射对象在使用时应该取消Java语言访问检查<br/>
<b>&nbsp;&nbsp;>. </b>提高反射效率。如果代码中必须使用反射，而该语句需要频繁的调用，那么设置为true。<br/>
<b>&nbsp;&nbsp;>. </b>使得原本无法访问私有成员也可以访问。<br/>
<b>>. </b>参数值为false则指示反射的对象应该实施Java语言访问检查。<br/>
</font></blockquote>

<hr />
<h3><font face="Courier new, 宋体"  color="#000">3.4.6 反射和普通调用方式性能测试</font></h3>

<font face="Courier New, 宋体" ><font color="#006600">【示例3.4-6】<font color="black"> 反射和普通调用之间性能测试.</font></font></font>

```java
package com.xiaxin.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 分析 计算机性能
 */
public class Test08 {
    /* 十亿次 */
    public static int turn =  (int) 1E9;
    
    /* 1. 普通方式调用 */
    public static void test01() {
        CustomTest customTest = new CustomTest();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < turn; i++) {
            customTest.getMsg();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    // 反射方式调用

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CustomTest customTest = new CustomTest();
        Class c1 = customTest.getClass();
        Method getMsg = c1.getDeclaredMethod("getMsg", null);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < turn; i++) {
            getMsg.invoke(customTest, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    // 反射方式调用 关闭检测

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CustomTest customTest = new CustomTest();
        Class c1 = customTest.getClass();

        long startTime = System.currentTimeMillis();
        Method getMsg = c1.getDeclaredMethod("getMsg", null);

        getMsg.setAccessible(true);
        for (int i = 0; i < turn; i++) {
            getMsg.invoke(customTest, null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭检查后，反射方式执行十亿次: " + (int)(endTime - startTime) / 1000 + "s" + (endTime - startTime) % 1000 + "ms");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
```
```bash
普通方式执行十亿次: 0s2ms
反射方式执行十亿次: 1s323ms
关闭检查后，反射方式执行十亿次: 0s772ms
```

<hr /><hr />

<h1><font face="Courier new, 宋体">4️⃣注解与反射的综合应用</font></h1>

<h2><font face="courier new, 宋体" color="purple">7️⃣⏺️1️⃣反射获取泛型信息</font></h2>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓介绍:</b><br/>
<font color="#000"><b>>. </b>Java采用泛型擦除的机制来引入泛型，Java中的泛型仅仅是给编译器javac使用的，确保数据的安全性和免去强制类型转换问题，但是，一旦变异完成，所有和泛型有关的类型全部擦除。<br/></font>
<font color="#000"><b>>. </b>为了通过反射操作这些类型，Java新增了ParameterizedType、GenericArrayType、TypeVariable和WildcardType几种类型来代表不能被归一到Class类中的类型但是有何原始类型齐名的类型。<br/></font>
<font color="#000"><b>>. ParameterizedType:</b> 表示一种参数化类型，比如Collection&lt;T>。 <br/></font>
<font color="#000"><b>>. GenericArrayType:</b> 表示一种元素类型是参数化类型或者变量的数组类型。 <br/></font>
<font color="#000"><b>>. TypeVariable:</b> 是各种类型变量的公共父接口。 <br/></font>
<font color="#000"><b>>. WildcardType:</b> 代表一种通配符类型表达式。 <br/></font>
</font></blockquote>

<font face="Courier New, 宋体" ><font color="#006600">【示例4.1-1】<font color="black"> 通过反射获取泛型有关信息。</font></font></font>

```java
package com.xiaxin.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型信息
 */
public class Test09<M> {
    public<T> void test01(Map<String, CustomTest> map, List<T> list) {
        System.out.println("method test01");
    }

    public<E extends M> Map<E, CustomTest> test02() {
        System.out.println("method test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test09.class.getMethod("test01", Map.class, List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("getGenericParameterTypes(): " + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("getActualTypeArguments(): " + actualTypeArgument);
                }
            }
        }

        method = Test09.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("getActualTypeArguments(): " + actualTypeArgument);
            }
        }

    }
}
```
```bash
getGenericParameterTypes(): java.util.Map<java.lang.String, com.xiaxin.reflection.example01.CustomTest>
getActualTypeArguments(): class java.lang.String
getActualTypeArguments(): class com.xiaxin.reflection.example01.CustomTest
getGenericParameterTypes(): java.util.List<T>
getActualTypeArguments(): T
getActualTypeArguments(): E
getActualTypeArguments(): class com.xiaxin.reflection.example01.CustomTest
```

<br />

<h2><font face="courier new, 宋体" color="purple">4️⃣⏺️2️⃣反射获取注解信息</font></h2>

<h3><font face="Courier new, 宋体"  color="#000">4.2.1 ORM框架中的应用</font></h3>


<img src="https://i-blog.csdnimg.cn/direct/bb73b8563d2046f787a405a4f2de795d.png#pic_center" alt="🚀" title=' photo'>
<br/>

<blockquote ><font face="Courier New, 宋体" color="#003399"><b>📓介绍ORM:</b><br/>
<font color="#000"><b>ORM:</b> Object Relationship Mapping --> 对象关系映射<br/></font>
<font color="#000"><b>◇ 类和表结构对应</b><br/></font>
<font color="#000"><b>◆ 属性和字段对应<br/></font>
<font color="#000"><b>◆ 对象性和记录对应</b> <br/></font>
<font color="#000"><b>要求:</b> 利用注解和反射完成类和表结构的映射关系. <br/></font>
</font></blockquote>


```java
package com.xiaxin.reflection.example01;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * ORM : 练习反射和注解
 */
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c = Class.forName("com.xiaxin.reflection.example01.Person");

        // 通过反射获得注解信息 仅用于运行时保留

        // 获取类上的注解信息
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation + " : " + annotation.annotationType());
        }

        // 获得注解的 value 的值
        TableName tName = (TableName) c.getAnnotation(TableName.class);
        System.out.println(tName.value());

        // 获得类指定元素的注解
        Field name = c.getDeclaredField("id");
        FieldName annotation = name.getAnnotation(FieldName.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@SuppressWarnings("all")
@TableName("tb_person")
class Person {
    @FieldName(columnName = "pid", type = "int", length = 9)
    private int id;
    @FieldName(columnName = "name", type = "varchar", length = 20)
    private String name;
    @FieldName(columnName = "gender", type = "char", length = 1)
    private char gender;

    public Person() {}

    public Person(int id, String name, int age, char gender) {
        this.name = name;
    }
}

/**
 * 类名的注解
 * @author Lenovo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableName {
    String value();
}

/**
 * 属性的注解
 * @author AiMi, UiQi, SiTi
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldName {
    String columnName();
    String type();
    int length();
}
```
```bash
@com.xiaxin.reflection.example01.TableName(value=tb_person) : interface com.xiaxin.reflection.example01.TableName
tb_person
pid
int
9
```


<hr/><font face="Courier New, 宋体" size=3 color="#333399"><b>📖原文</b>: 无意义的热闹，远不如有意义的孤独。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时不时的欢愉，不如销声匿迹的沉淀。<br/></font><font face="Courier New, 宋体" size=3 color="#006600"><b>⌛怡然</b>: ...<br/></font>
<hr/>

<hr/>
<center><b><font face="Courier New, 宋体" size=4 color="#F08080">🪁 UiQi looks forward to seeing you again 🌌</font></b></center>
<hr/>

<!--
	Date:  2025-02-14
	Auther: UiQi
	Version: 1.0
	Category: 文档
	Updated: 2025-02-14
-->














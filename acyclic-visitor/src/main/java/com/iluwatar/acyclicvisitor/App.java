/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.acyclicvisitor;

import com.iluwatar.acyclicvisitor.interfaces.HayesVisitor;
import com.iluwatar.acyclicvisitor.interfaces.ModemVisitor;
import com.iluwatar.acyclicvisitor.interfaces.ZoomVisitor;

/**
 * The Acyclic Visitor pattern allows new functions to be added to existing class 
 * hierarchies without affecting those hierarchies, and without creating the dependency 
 * cycles that are inherent to the GoF Visitor pattern, by making the Visitor base class 
 * degenerate
 * <p>
 * In this example the visitor base class is {@link ModemVisitor}. The base class of the
 * visited hierarchy is {@link Modem} and has two children {@link Hayes} and {@link Zoom} 
 * each one having its own visitor interface {@link HayesVisitor} and {@link ZoomVisitor}
 * respectively. {@link ConfigureForUnixVisitor} and {@link ConfigureForDosVisitor} 
 * implement each derivative's visit method only if it is required
 *
 * 译文
 * 无循环访问者模式允许向现有的类层次结构添加新函数，而不影响这些层次结构，
 * 也不创建GoF访问者模式固有的依赖循环，方法是使访问者基类退化
 *
 * 在这个例子中，访问者基类是{@link ModemVisitor}.
 * 被访问层次结构的基类是{@link Modem}，它有两个孩子 {@link Hayes}和{@link Zoom}.
 * 每个孩子都有自己的访问者接口{@link HayesVisitor}和{@link ZoomVisitor} 。
 * {@link ConfigureForUnixVisitor} 和{@link ConfigureForDosVisitor} 仅在需要时才实现每个派生的访问方法
 */
public class App {
  
  /**
   * Program's entry point
   * 程序 的 入口点
   */
  
  public static void main(String[] args) {
    //可以用 zoom 一个接口
    ModemVisitor conUnix = new ConfigureForUnixVisitor();
    //可以用 Hayes与Zoom 两个接口
    ModemVisitor conDos = new ConfigureForDosVisitor();
    //可以用 Hpf 一个接口
    ModemVisitor hpfDos = new ConfigureForHpfVisitor();

    Modem zoom = new Zoom();
    Modem hayes = new Hayes();
    Modem hpf = new Hpf();

    hpf.accept(hpfDos);

    hayes.accept(conDos); // Hayes modem with Unix configurator 使用Unix配置器的Hayes调制解调器
    zoom.accept(conDos); // Zoom modem with Dos configurator    使用Dos配置器的Zoom调制解调器
    hayes.accept(conUnix); // Hayes modem with Unix configurator带有Unix配置器的Hayes调制解调器
    zoom.accept(conUnix); // Zoom modem with Unix configurator  使用Unix配置器的Zoom调制解调器


  }
}

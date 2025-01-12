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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hayes class implements its accept method
 * Hayes类实现了Modem的accept方法
 */
public class Hayes extends Modem {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);

  /**
   * Accepts all visitors but honors only HayesVisitor
   * 接受所有访客，但只使用HayesVisitor
   */
  @Override
  public void accept(ModemVisitor modemVisitor) {
    if (modemVisitor instanceof HayesVisitor) {
      ((HayesVisitor) modemVisitor).visit(this);
    } else {
      LOGGER.info("Only HayesVisitor is allowed to visit Hayes modem");
      LOGGER.info("“只有HayesVisitor被允许访问Hayes调制解调器”");
    }

  }
  
  /**
   * Hayes' modem's toString
   * method
   */
  @Override
  public String toString() {
    return "Hayes modem";
  }
}

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
package com.iluwatar.abstractfactory;

import com.iluwatar.abstractfactory.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iluwatar.abstractfactory.Kingdom.FactoryMaker.KingdomType;

/**
 * 
 * The Abstract Factory pattern provides a way to encapsulate a group of individual factories that have a common theme
 * without specifying their concrete classes. In normal usage, the client software creates a concrete implementation of
 * the abstract factory and then uses the generic interface of the factory to create the concrete objects that are part
 * of the theme. The client does not know (or care) which concrete objects it gets from each of these internal
 * factories, since it uses only the generic interfaces of their products. This pattern separates the details of
 * implementation of a set of objects from their general usage and relies on object composition, as object creation is
 * implemented in methods exposed in the factory interface.
 *
 * <p>
 * The essence of the Abstract Factory pattern is a factory interface ({@link KingdomFactory}) and its implementations (
 * {@link ElfKingdomFactory}, {@link OrcKingdomFactory}). The example uses both concrete implementations to create a
 * king, a castle and an army.
 *
 * 将对象与对象之间的关系抽象出来
 *
 * 译文
 * 抽象工厂模式提供了一种方法来封装一组具有公共主题的单独工厂，而无需指定它们的具体类。
 * 在通常情况下，客户端软件创建抽象工厂的具体实现，然后使用工厂的通用接口创建主题的具体对象。
 * 客户机不知道(或不关心)它从这些内部工厂中获得哪些具体对象，因为它只使用它们产品的通用接口。
 * 此模式将一组对象的细节或实现与其一般用法分离开来，并依赖于对象组合，因为对象创建是在工厂接口中公开的方法中实现的
 *
 * 抽象工厂模式的本质是一个工厂接口(({@link KingdomFactory})及其实现{@link ElfKingdomFactory}, {@link OrcKingdomFactory}).。
 * 该示例同时使用了具体的实现来创建国王、城堡和军队。
 */
public class Kingdom {

  private static final Logger LOGGER = LoggerFactory.getLogger(Kingdom.class);

  private King king;
  private Castle castle;
  private Army army;

  /**
   * 创建王国
   */
  public void createKingdom(final KingdomFactory factory) {
    setKing(factory.createKing());
    setCastle(factory.createCastle());
    setArmy(factory.createArmy());
  }
  
  King getKing(final KingdomFactory factory) {
    return factory.createKing();
  }

  public King getKing() {
    return king;
  }

  private void setKing(final King king) {
    this.king = king;
  }
  
  Castle getCastle(final KingdomFactory factory) {
    return factory.createCastle();
  }

  public Castle getCastle() {
    return castle;
  }

  private void setCastle(final Castle castle) {
    this.castle = castle;
  }
  
  Army getArmy(final KingdomFactory factory) {
    return factory.createArmy();
  }

  public Army getArmy() {
    return army;
  }

  private void setArmy(final Army army) {
    this.army = army;
  }

  /**
   * 创建王国工厂的工厂(工厂生产者)
   */
  public static class FactoryMaker {

    /**
     * 枚举不同类型的王国。
     */
    public enum KingdomType {
      ELF, ORC
    }

    /**
     * 。创建 KingdomFactory 具体对象的工厂方法。
     */
    public static KingdomFactory makeFactory(KingdomType type) {
      switch (type) {
        case ELF:
          return new ElfKingdomFactory();
        case ORC:
          return new OrcKingdomFactory();
        default:
          throw new IllegalArgumentException("KingdomType not supported.");
      }
    }
  }

  /**
   * Program entry point.
   * 
   * @param args
   *          command line args
   */
  public static void main(String[] args) {

    Kingdom app = new Kingdom();

    LOGGER.info("Elf Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(KingdomType.ELF));
    LOGGER.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());

    LOGGER.info("Orc Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(KingdomType.ORC));
    LOGGER.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());
  }
}
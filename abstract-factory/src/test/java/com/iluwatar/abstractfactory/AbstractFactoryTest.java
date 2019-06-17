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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iluwatar.abstractfactory.Kingdom.FactoryMaker;
import com.iluwatar.abstractfactory.Kingdom.FactoryMaker.KingdomType;

import com.iluwatar.abstractfactory.interfaces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for abstract factory
 */
public class AbstractFactoryTest {

  private Kingdom app = new Kingdom();
  private KingdomFactory elfFactory;
  private KingdomFactory orcFactory;

  @BeforeEach
  public void setUp() {
    //创建精灵工厂
    elfFactory = FactoryMaker.makeFactory(KingdomType.ELF);
    //创建兽人工厂
    orcFactory = FactoryMaker.makeFactory(KingdomType.ORC);
  }

  @Test
  public void king() {
    //app为当前王国,设置当前王国的国王为精灵族
    final King elfKing = app.getKing(elfFactory);
    //判断app的当前国王是否是精灵国王
    assertTrue(elfKing instanceof ElfKing);
    //判断app的当前国王的描述是否是精灵国王的描述
    assertEquals(ElfKing.DESCRIPTION, elfKing.getDescription());

    //app为当前王国,设置当前王国的国王为兽人族
    final King orcKing = app.getKing(orcFactory);
    //判断app的当前国王是否是兽人国王
    assertTrue(orcKing instanceof OrcKing);
    //判断app的当前国王的描述是否是兽人国王的描述
    assertEquals(OrcKing.DESCRIPTION, orcKing.getDescription());
  }

  @Test
  public void castle() {
    final Castle elfCastle = app.getCastle(elfFactory);
    assertTrue(elfCastle instanceof ElfCastle);
    assertEquals(ElfCastle.DESCRIPTION, elfCastle.getDescription());
    final Castle orcCastle = app.getCastle(orcFactory);
    assertTrue(orcCastle instanceof OrcCastle);
    assertEquals(OrcCastle.DESCRIPTION, orcCastle.getDescription());
  }

  @Test
  public void army() {
    final Army elfArmy = app.getArmy(elfFactory);
    assertTrue(elfArmy instanceof ElfArmy);
    assertEquals(ElfArmy.DESCRIPTION, elfArmy.getDescription());
    final Army orcArmy = app.getArmy(orcFactory);
    assertTrue(orcArmy instanceof OrcArmy);
    assertEquals(OrcArmy.DESCRIPTION, orcArmy.getDescription());
  }

  @Test
  public void createElfKingdom() {
    //app为当前王国,设置当前王国的统治者为精灵族
    app.createKingdom(elfFactory);
    final King king = app.getKing();
    final Castle castle = app.getCastle();
    final Army army = app.getArmy();
    assertTrue(king instanceof ElfKing);
    assertEquals(ElfKing.DESCRIPTION, king.getDescription());
    assertTrue(castle instanceof ElfCastle);
    assertEquals(ElfCastle.DESCRIPTION, castle.getDescription());
    assertTrue(army instanceof ElfArmy);
    assertEquals(ElfArmy.DESCRIPTION, army.getDescription());
  }

  @Test
  public void createOrcKingdom() {
    app.createKingdom(orcFactory);
    final King king = app.getKing();
    final Castle castle = app.getCastle();
    final Army army = app.getArmy();
    assertTrue(king instanceof OrcKing);
    assertEquals(OrcKing.DESCRIPTION, king.getDescription());
    assertTrue(castle instanceof OrcCastle);
    assertEquals(OrcCastle.DESCRIPTION, castle.getDescription());
    assertTrue(army instanceof OrcArmy);
    assertEquals(OrcArmy.DESCRIPTION, army.getDescription());
  }
}

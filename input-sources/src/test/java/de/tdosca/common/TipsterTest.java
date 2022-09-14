/*
* TipsterTest.java of tdosca-tc14 is licensed under BSD-3-Clause-License:
*
* SPDX-License-Identifier: BSD-3-Clause
*
* Copyright (C) 2022 kreincke / Deutsche Telekom AG
*/


package de.tdosca.common;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TipsterTest {

  Tipster tipster;

  @Before
  public void setup() {
    tipster = new Tipster();
  }

  @Test
  public void test1() {
    assertEquals("back0", tipster.speak());
  }

}

package chess;

import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;

import chess.pieces.PawnTest;

@RunWith(Suite.class)
@SuiteClasses({BoardTest.class, PawnTest.class})
public class AllTests {

}

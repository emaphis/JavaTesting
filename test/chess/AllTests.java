package chess;

import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Suite.SuiteClasses;

import chess.pieces.PawnTest;
import chess.util.StringUtilTest;

@RunWith(Suite.class)
@SuiteClasses({BoardTest.class,
			   PawnTest.class,
			   CharacterTest.class,
			   StringUtilTest.class})
public class AllTests {

}

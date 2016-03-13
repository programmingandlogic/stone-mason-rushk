/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */


import stanford.karel.*;
public class StoneMasonKarel extends SuperKarel {


	// precondtition: Karel is in the bottom left hand corner (1,1) facing East
	// postcondition: Karel is in the bottom right hand corner (13, 1) facing South

	public static final String CN = "StoneMasonKarel";
	
	public void run() {
		turnLeft();
		buildArch();
		moveToNewArch();
		buildArch();
		moveToNewArch();
		buildArch();
		moveToNewArch();
		buildArch();
	}

	private void buildArch() {
		System.out.println( CN + ".buildArch" );
		System.out.println( "\tfrontIsClear :" + frontIsClear() );
		if ( frontIsClear() ) {
			System.out.println( "\tmoving" );
			if( noBeepersPresent() ){
				putBeeper();				
			}
			move();
		}	
	}

	private void moveToNewArch() {
		System.out.println( CN + ".moveToNewArch" );

		while (facingNorth()) {
			
			if (frontIsBlocked()) {
				turnRight();
				move();
				move();
				move();
				move();
				turnRight();
			}

			if (frontIsClear()) {
				buildArch();
			}
		}


		while (facingSouth()) {

			if (frontIsBlocked()) {
				turnLeft();
				if( !frontIsBlocked() ){
					move();
					move();
					move();
					move();
					turnLeft();					
				} else {
					System.out.println( "Karel is finished!!" );
				}
			}

			if (frontIsClear()) {
				buildArch();
			}
		}
	}
}


// 1) buildArch
// 2) moveToNewArch
// 3) repeat 4 times



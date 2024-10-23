package com.pluralsight.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_shouldMark_roomAsDirty() {
        Room room = new Room();

        room.checkIn();

        boolean isDirty = room.isDirty();
        assertTrue(isDirty);
    }

    @Test
    void checkIn_shouldMark_roomAsOccupied() {
        Room room = new Room();

        room.checkIn();

        boolean isOccupied = room.isOccupied();
        assertTrue(isOccupied);
    }

    @Test
    void checkIn_shouldNotWork_ifRoomIsDirty() {
        Room room = new Room();
        room.setDirty(true);

        room.checkIn();

        boolean isOccupied = room.isOccupied();
        assertFalse(isOccupied);
        boolean isDirty = room.isDirty();
        assertTrue(isDirty);

    }

    @Test
    void checkIn_shouldNotWork_ifRoomIsOccupied() {
        Room room = new Room();
        room.setOccupied(true);

        room.checkIn();

        boolean isDirty = room.isDirty();
        assertFalse(isDirty);
        boolean isOccupied = room.isOccupied();
        assertTrue(isOccupied);

    }

    @Test
    void checkIn_shouldFail_afterCheckout_ifNotCleaned(){
        Room room = new Room();
        room.checkIn();
        room.checkOut();

        room.checkIn();
        assertTrue(room.isDirty());
    }


    @Test
    void checkOut_shouldSet_roomToNotOccupied() {
        Room room = new Room();
        room.checkIn();

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }



    @Test
    void cleanRoom_shouldMark_roomToClean() {
        Room room = new Room();
        room.checkIn();
        room.checkOut();

        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    void cleanRoom_shouldNotWork_ifRoomIsOccupied() {
        Room room = new Room();
        room.checkIn();

        room.cleanRoom();

        assertTrue(room.isDirty());
    }
}
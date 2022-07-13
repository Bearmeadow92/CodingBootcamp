// FRIDAY -------------------------------------------------------------------//
    /**
 * Concatenates the nodes of a given list onto the back of this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {SinglyLinkedList} addList An instance of a different list whose
 *    whose nodes will be added to the back of this list.
 * @returns {SinglyLinkedList} This list with the added nodes.
 */ 
    concat(addList) {
    
    }

    /**
    * Finds the node with the smallest number as data and moves it to the front
    * of this list.
    * - Time: O(?).
    * - Space: O(?).
    * @returns {SinglyLinkedList} This list.
    */
    moveMinToFront() { 

    }

   // EXTRA
    /**
    * Splits this list into two lists where the 2nd list starts with the node
    * that has the given value.
    * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
    * and the return value will be a new list containing (5=>2=>4)
    * - Time: O(?).
    * - Space: O(?).
    * @param {any} val The value in the node that the list should be split on.
    * @returns {SinglyLinkedList} The split list containing the nodes that are
    *    no longer in this list.
    */
    splitOnVal(val) {

    }

    
    removeVal(val) {
    // 1. LIST IS EMPTY
    if(this.head === null){
        return false
    }
    // 2. LIST IS NOT EMPTY
    if(this.head.next === null && val === this.head.value){
        this.head = null
    }
    // CREATE A RUNNER

    // HAVE THE RUNNER GO DOWN THE SLL, CHECK TO SEE IF NEXT NODE'S VALUE
    // MATCHES THE val

    // SET A TEMP VARIABLE TO THE NODE TO DELETE

    // HAVE THE RUNNER SKIP THE NODE TO DELETE
    
    // SET THE TEMP POINT TO A NULL

    // runner.next.value == val
    // var temp = runner.next
    // runner.next = runner.next.next

}
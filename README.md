# Hashtable

Complete the implementation of the hashtable in the class `ci583.htable.Hashtable.java`. 

## The constructors

When a new Hashtable is created, the array should be initialised with a size which is the smallest prime number 
larger than or equal to the requested initial capacity. So before you can complete the constructors, you will need
to implement `isPrime` and `nextPrime`. The default probe type should be `LINEAR_PROBE`. 

# The `getLoadFactor` method

This is the ratio of the number of items stored to the size of the array. Note that both of these values are integers.
If you do any arithmetic with two integers in Java the result will also be an integer, rounded up or down. So `2/4` is
equal to zero. To get around this, cast one of the values to a `double` before the division.

# The `put` method

If the key supplied to this method is `null`, you should immediately throw an `IllegalArgumentException`. If the load
factor is greater than or equal to the maximum load factor, you should resize the hashtable (see below). Then `put`
needs to:

+ use the `hash` method to get the hash value of the key,
+ create a new `Pair` object,
+ store the object at the index found by calling `findEmptyOrSameKey` method to find a location which is either 
  unoccupied or contains a pair object with the same key, starting the search at the value found by hashing the 
  key and with a stepNum of one,
+ increment `itemCount` only if the new object has a key that has not been stored before (use `hasKey` *before* 
  storing the new object).
  
# The `hash` method

In the `hash` method you need to turn the key, which is a string, into a value that can be used as an index into the
array. The normal way to do this is by calculating a large integer value based on the string then using modular
arithmetic to divide that number by the size of the array and returning the remainder:

```
hash = largeValue % max;
```
This will ensure that `hash` is a value between zero and one less than the size of the array. There is a basic hash 
function in my slides from the week we covered hashtables. If you use that one be sure to alter the constants 96 and
27 to something more appropriate (and to understand why they are there in the first place and so why they should 
changed). You can make your data structure much more efficient and faster by doing some research to find a more 
efficient hash function online (and possibly translating it into Java -- many of the most
efficient hash functions are written in languages such as C).

# The `findEmptyorSameKey` method

This method returns a suitable index to store a pair object which is either new or is using a key that has already
been stored. Use the `startPos` parameter as an index to the array. There are thee options:
+ the position is empty -- return `startPos`,
+ the position is occupied by a pair object with the same key -- return `startPos`,
+ the position is occupied by a pair object with a different key. Call `getNextLocation` to find the next place to look
  and return the result of a recursive call to `findEmptyOrSameKey` called with an incremented value of `stepNum`.

# The `resize` method

This method requires the following steps:
+ set `max` to a new value which is a prime number at least twice as large as the previous value,
+ reset `itemCount` to zero,
+ make a copy of the array,
+ set the array to be a new empty array with size `max`,
+ loop through the old array calling put for every position that is not `null`. 

# The `get` method

In this method you simply return the result of calling `find`, passing in the hashed key, the key itself and a 
`stepNum` of one. Because the object may not exist, return an `Optional`.

# The `find` method

This method is similar to `findEmptyOrSameKey` except that you will be returning an `Optional` which is either
empty or contains the value of the object with the right key. The steps are as follows:
+ if `startPos` points to an index in the array which is empty, return `Optional.empty()`,
+ if it points to an object with a different key, call `getNextLocation` then return the result of a recursive call
  to `find`, passing in the new location and an incremented value of `stepNum`,
+ if it points to an object with the same key, return an `Optional` containing that object's value.

# The `hasKey` method

You can implement this one simply by calling `get` and checking whether the result contains a value.

# The `getKeys` method

Make a new collection (such as an `ArrayList`) then loop through the array, adding the key of every object ot the 
collection. Finally, return the collection.

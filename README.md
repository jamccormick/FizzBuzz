# Common Interviewing Questions

I'm beginning some work on a website that will eventually have a series of common interviewing questions placed on it.  

The reason is simple: I would rather get to the meat and potatoes of an interview rather than sit and whiteboard.  As an interviewer, I presume you have questions about the code I'm going to write.  Therefore, I'm giving you, the interviewer, more time to ask questions by giving you the answers to the coding questions you're most likely to ask.

Is this a bit of self-gratification on my part?  You bet.  I'll openly state the absurdity of what I'm doing here: taking a simple question and complicating it to an absurd extreme.  But hey, it's a chance to play with Java 15, Spring, and even eventually write a frontend, because I don't do that very often.  

# FizzBuzz

This one is perhaps the single most commonly asked question in programming interviews.  I've leveraged a database for the purposes of ensuring ease of modification.  Right now, it's in a pre-MVP state.  Future enhancements include:

* Per-user value additions and substitution changes.  One of the most common follow-up questions here is about modifying the behavior of FizzBuzz.  And after a decade of thinking way too long and hard about it (because I think about it every time it comes up on /r/programming because there's *someone* claiming to be unable to whiteboard FizzBuzz).  I want you to be able to modify the output of FizzBuzz without my intervention.  There will be a CRUD system forthcoming.
* A React-based frontend for the CRUD elements
* Containerization via Docker

# Fibonacci

I've solved this in two methods: recursively using a cache and iteratively.  I *could* sidestep the cache for the recursive mechanism, but you should realize that the time complexity of that particular operation is O(e^n).  While I can't stop the call stack from exploding, I can make each entry into a random access lookup through the use of a hash table.  So I did.

The iterative version has linear time complexity.  It is, therefore, the preferred solution.

# Quicksort

This particular question should be deprecated.  It's not the best way to handle sorting in Java--or any language with built-in collection types, for that matter.  It is better to implement Comparable and use the built-in sorting function.  Why?  Because Java uses [Timsort](https://en.wikipedia.org/wiki/Timsort), which sidesteps Quicksort's worst case time complexity scenario (which happens when you choose a pivot that is an extreme).  This solution does not attempt to do any serious work at mitigating the worst case performance scenario, which produces O(n^2) time complexity.  

I suspect it's still commonly asked because it *does* require a grasp of recursion.  And because it's still very common, I've included a solution here.

I took pains to preserve the original array so that you can compare the sorted and unsorted forms.  
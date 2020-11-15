#Common Interviewing Questions

I'm beginning some work on a website that will eventually have a series of common interviewing questions placed on it.  

The reason is simple: I would rather get to the meat and potatoes of an interview rather than sit and whiteboard.  As an interviewer, I presume you have questions about the code I'm going to write.  Therefore, I'm giving you, the interviewer, more time to ask questions by giving you the answers to the coding questions you're most likely to ask.

#FizzBuzz

This one is perhaps the single most commonly asked question in programming interviews.  I've leveraged a database for the purposes of ensuring ease of modification.  Right now, it's in an MVP state.  Future enhancements include:

* Per-user value additions and substitution changes.  One of the most common follow-up questions here is about modifying the behavior of FizzBuzz.  And after a decade of thinking way too long and hard about it (because I think about it every time it comes up on /r/programming because there's *someone* claiming to be unable to whiteboard FizzBuzz).  I want you to be able to modify the output of FizzBuzz without my intervention.  There will be a CRUD system forthcoming.
* A React-based frontend for the CRUD elements
* Containerization via Docker

#Fibonacci

I've solved this in two methods: recursively using a cache and iteratively.  I *could* sidestep the cache for the recursive mechanism, but you should realize that the time complexity of that particular operation is O(e^n).  While I can't stop the call stack from exploding, I can make each entry into a random access lookup through the use of a hash table.  So I did.

The iterative version has linear time complexity.  It is, therefore, the preferred solution.
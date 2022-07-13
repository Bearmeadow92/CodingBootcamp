/* 
Given in an alumni interview in 2021.
String Encode
You are given a string that may contain sequences of consecutive characters.
Create a function to shorten a string by including the character,
then the number of times it appears. 


If final result is not shorter (such as "bb" => "b2" ),
return the original string.
*/

const str1 = "aaaabbcddd";
// const expected1 = "a4b2c1d3";

// const str2 = "";
// const expected2 = "";

// const str3 = "a";
// const expected3 = "a";

// const str4 = "bbcc";
// const expected4 = "bbcc";


function encodeStr(str) {
    var count = 1
    var string = ""
    var char = ""
    for( var i = 0; i < str.length; i++){
        if(str[i] === str[i+1]){
        count ++
        char = str[i]
        console.log(char)
        console.log(count)
        }
    }
}
    // ITERATE THROUGH str
        //FIND LIKE CHARACTERS AND KEEP COUNT ON CHARS
        // ONCE WE FIND A NEW CHARACTER, START A NEW COUNT
    //CONCAT THE CHARACTER AND FREQUENCY TO THE SOLUTION
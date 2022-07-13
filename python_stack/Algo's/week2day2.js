/* 
    Given a string,
    return a new string with the duplicates excluded
    Bonus: Keep only the last instance of each character.
*/

const str1 = "abcABC";
// const expected1 = "abcABC";

const str2 = "helloo";
// const expected2 = "helo";

const str3 = "helloolllleeerrrrrr";
// const expected3 = "helor";

// /**
//  * De-dupes the given string.
//  * - Time: O(?).
//  * - Space: O(?).
//  * @param {string} str A string that may contain duplicates.
//  * @returns {string} The given string with any duplicate characters removed.
//  */
// // freq counter {h:1, e: 1, l:2, o:2} 
// seen = {h: true, e: true, l: true  }
// seen = {h: true, e:true, l: true}
// seen[l] = true
seen = {}
function stringDedupe(str3) {
  // 
  // for loop check for duplicates
    for (let i = 0; i < str3.length; i++){
        if (str1[i]){
        // console.log(str3[i])
            seen[str1[i]] = true
            // console.log(seen)
        }
    }
    var newStrArr = Object.keys(seen)
    var resultStr = ""
    for(let j = 0; j < newStrArr.length; j++) {
        resultStr += newStrArr[j]
    }
    return resultStr
} 


// stringDedupe(str1)
// stringDedupe(str2)
// stringDedupe(str3)
// console.log(seen)
// console.log(Object.keys(seen))
console.log(stringDedupe(str1))
// module.exports = { stringDedupe };
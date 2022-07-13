/* 
    Efficiently combine two already sorted multiset arrays 
    into an array containing the sorted set intersection of the two.
    Output: only the shared values between the two arrays (deduped).
    Venn Diagram Visualization (bottom) https://i.ytimg.com/vi/sdflTUW6gHo/maxresdefault.jpg
*/

const numsA1 = [0, 1, 2, 2, 2, 7];
const numsB1 = [2, 2, 6, 6, 7];
const expected1 = [2, 7];

const numsA2 = [0, 1, 2, 2, 2, 7];
const numsB2 = [2, 2];
const expected2 = [2];

const numsA3 = [0, 1, 2, 2, 2, 7];
const numsB3 = [10];
const expected3 = [];

/**
 * Efficiently combine the two sorted arrays into a new array that is the a
 * sorted set intersection.
 * Venn Diagram Visualization (bottom):
 * @see https://i.ytimg.com/vi/sdflTUW6gHo/maxresdefault.jpg
 * - Time: O(?).
 * - Space: O(?).
 * @param {Array<number>} sortedA
 * @param {Array<number>} sortedB Both sets are multisets
 *    (multi in that it can contain multiple dupes).
 * @returns {Array<number>} The sorted set intersection: a new array that is
 *    sorted and contains only the shared values between the two arrays
 *    deduped.
 */
function orderedIntersection(sortedA, sortedB) {
    // CREATE A NEW ARRAY TO PUSH THE intersectionValues into
    const set = newSet(sortedB);
    const orderedInterestion = new Set(sortedA.filter(elem => set.has(elem)))
    return Array.from(orderedIntersection); 
    let 

//     const sortedAs = new Set(sortedA)
//     const sortedBs = new Set(sortedB)
//     const newArray = [];
//     console.log(newArray)
//     console.log(sortedAs)
//     console.log(sortedBs)
//     for(let i = 0; i < sortedAs.length; i++){
//         for (let j = 0; j < sortedBs.length; j++){
//             if(sortedAs[i] === sortedBs[j]){

//                 newArray.push(sortedAs[i])
//             }
//             console.log(newArray)
//         }
//     }
//     console.log(newArray)
// }
// orderedIntersection(numsA1, numsB1)
# 1: Update Values in Dictionaries and Lists
# x = [ [5,2,3], [10,8,9] ]
# x[1][0] = 15
# print(x)


# students = [
#     {'first_name':  'Michael', 'last_name' : 'Jordan'},
#     {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# students[0]['last_name'] = 'Bryant'
# print(students)

# sports_directory['soccer'][0] = 'Andres'
# print(sports_directory)

# z [0]['y'] = 30
# print(z)


# 2 Iterate Through a List of Dictionaries
students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def iterateDictionary(some_list):
    for students in some_list:
        print(f'first_name - {students["first_name"]} , last_name - {students ["last_name"]}')

# iterateDictionary(students) 

# # 3 Get Values From a List of Dictionaries

def iterateDictionary2(key_name, some_list):
    for students in some_list:
        print(students[key_name])

iterateDictionary2("first_name", students)
iterateDictionary2("last_name", students)

#4 Iterate Through a Dictionary with List Values

# dojo = {
#     'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
#     'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
# }

# def printInfo(some_dict):
#     print(len(some_dict["locations"]), "LOCATIONS")
#     for locations in some_dict ["locations"]: 
#         print(locations)
    
#     print()
#     print(len(some_dict["instructors"]), "INSTRUCTORS")
#     for instructors in some_dict ["instructors"]: 
#         print(instructors)

# printInfo(dojo)


# printInfo(dojo)
# # output:
# 7 LOCATIONS
# San Jose
# Seattle
# Dallas
# Chicago
# Tulsa
# DC
# Burbank
    
# 8 INSTRUCTORS
# Michael
# Amy
# Eduardo
# Josh
# Graham
# Patrick
# Minh
# Devon

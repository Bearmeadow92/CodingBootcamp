from pprint import pprint
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models.ninja import Ninja

DATABASE = 'dojos_and_ninjas_schema'
class Dojo:
    def __init__( self , data ):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = [] 

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojos;"
        results = connectToMySQL(DATABASE).query_db(query)
        print(results)
        dojos = []
        for dojo in results:
            dojos.append( cls(dojo) )
        return dojos

    @classmethod
    def save(cls, data ):
        query = "INSERT INTO dojos ( name ) VALUES (%(name)s);"
        return connectToMySQL(DATABASE).query_db( query, data )

    @classmethod
    def get_dojo_with_ninjas(cls, data):
        query = "SELECT * FROM dojos LEFT JOIN ninjas ON ninjas.dojo_id = dojos.id WHERE dojos.id = %(id)s;"
        results = connectToMySQL(DATABASE).query_db(query, data)
        print(results)
        dojo = cls(results[0])
        print(dojo)
        print(results[0]["last_name"])
        for result in results:
            ninja_data = {
                'id' : result['ninjas.id'],
                'first_name' : result['first_name'],
                'last_name' : result['last_name'],
                'age' : result['age'],
                'created_at' : result ['ninjas.created_at'],
                'updated_at' : result ['ninjas.updated_at'],
            }
            dojo.ninjas.append(Ninja(ninja_data))
        print(dojo.ninjas)
        return dojo
        pprint(results)
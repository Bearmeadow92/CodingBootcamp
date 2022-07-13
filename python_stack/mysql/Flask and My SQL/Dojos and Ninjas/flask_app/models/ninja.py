from pprint import pprint
from flask_app.config.mysqlconnection import connectToMySQL

DATABASE = 'dojos_and_ninjas_schema'
class Ninja:
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM ninjas;"
        results = connectToMySQL(DATABASE).query_db(query)
        print(results)
        ninjas = []
        for ninja in results:
            ninjas.append( cls(ninja) )
        return ninjas

    @classmethod
    def save(cls, data ):
        query = "INSERT INTO ninjas ( first_name, last_name, age, dojo_id ) VALUES (%(first_name)s, %(last_name)s, %(age)s, %(dojos_id)s);"
        test = connectToMySQL(DATABASE).query_db( query, data )
        return test
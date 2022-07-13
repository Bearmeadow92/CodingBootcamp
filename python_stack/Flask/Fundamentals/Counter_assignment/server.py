from flask import Flask, render_template, redirect, session

app = Flask(__name__)
app.secret_key = "kiskis" #secret key


@app.route('/')
def yolo():
    if 'counter' not in session:
        session['counter'] = 0
    else:
        session['counter'] += 1
    return render_template('index.html')

@app.route('/destroy_session')
def yee():
    session.clear()
    return redirect('/')


if __name__=="__main__":

    app.run(debug=True) 
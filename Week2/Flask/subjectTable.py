from flask import Flask, render_template

app = Flask(__name__, template_folder='templates')

@app.route('/marks')
def show_marks():
    # Create a dictionary of subjects and marks
    marks = {
        'Physics': 85,
        'Chemistry': 90,
        'Math': 95
    }
    return render_template('table.html', marks=marks)


if __name__ == '__main__':
    app.run(debug=True)

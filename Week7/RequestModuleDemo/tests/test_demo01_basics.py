import requests

def test_basics():
    response = requests.get("https://jsonplaceholder.typicode.com/posts/1")
    print(response.status_code)
    print(response.json())
    print(response.text)

    assert response.status_code == 200

def test_parametrize():
    response = requests.get("https://jsonplaceholder.typicode.com/comments")
    params = {"postId": 1}
    response = requests.get("https://jsonplaceholder.typicode.com/comments", params=params)


def test_post():
    post_data = {
        "postId": 1,
        "name": "john",
        "email": "ahksd@daj.asd",
        "body": "this is a test post",
    }
    response = requests.post("https://jsonplaceholder.typicode.com/posts", json = post_data)
    assert response.status_code == 201
    assert response.json()["name"] == "john"

# why do we use try-except?
def test_not_found():
    params = {"postId": 999}
    try:
        response = requests.get("https://jsonplaceholder.typicode.com/posts", params=params)
        response.raise_for_status()
        print(f"Response status code: {response.status_code}")
    except requests.HTTPError as e:
        print(f"Response status code: {e.response.status_code}")
import requests
import pytest

@pytest.fixture(scope="module")
def base_url():
    return "https://jsonplaceholder.typicode.com/"

@pytest.fixture(scope="module")
def session():
    session = requests.Session()
    session.headers.update({
        "Accept": "application/json",
        "Content-Type": "application/json"
    })
    yield session
    session.close()

def sample_post():
    return {
        "title":"Test Post",
        "body":"Test Body",
        "userId":1
    }

def test_create_post(base_url,session):
    params = sample_post()
    response = session.post(f"{base_url}/posts", json=params)
    assert response.status_code == 201
    data = response.json()

class TestBasicRequest:
    def test_get_single_post(self, base_url, session):
        response = session.get(f"{base_url}/posts/1")
        assert response.status_code == 200
        data = response.json()
        assert data["userId"] == 1
        assert "title" in data


    @pytest.mark.parametrize("post_id", [1, 2])
    def test_get_single_user_params(self, base_url, session, post_id):
        response = session.get(f"{base_url}/posts/{post_id}")
        assert response.status_code == 200
        data = response.json()
        assert data["userId"] == 1

    @pytest.mark.parametrize("user_id,expected_name", [
        (1, "Leanne Graham"),
        (2, "Ervin Howell"),
        (3, "Clementine Bauch"),
        (4, "Patricia Lebsack"),
        (5, "Chelsey Dietrich")
    ])
    def test_user_names(self, base_url, session, user_id, expected_name):
        response = session.get(f"{base_url}/users/{user_id}")

        assert response.status_code == 200
        assert response.json()["name"] == expected_name

    @pytest.mark.parametrize("endpoint,expected_count", [
        ("/posts", 100),
        ("/users", 10),
        ("/comments", 500),
        ("/albums", 100),
        ("/photos", 5000),
        ("/todos", 200)
    ])
    def test_resource_counts(self, base_url, session, endpoint, expected_count):
        response = session.get(f"{base_url}{endpoint}")

        assert response.status_code == 200
        assert len(response.json()) == expected_count

class TestResponseValidation:

    def test_response_time(self, base_url, session):
        response = session.get(f"{base_url}/posts/1")
        assert response.status_code == 200
        assert response.elapsed.total_seconds() < 1

    def test_response_headers(self, base_url, session):
        response = session.get(f"{base_url}/posts/1")
        assert "Content-Type" in response.headers
        assert "application/json" in response.headers["Content-Type"]

    def test_email_format(self,base_url, session):
        response = session.get(f"{base_url}/users/1")
        email = response.json()["email"]
        assert "@" in email
        assert "." in email.split("@")[1]

    def test_all_posts_have_required_fields(self, base_url, session):
        response = session.get(f"{base_url}/posts")
        posts = response.json()

        for post in posts:
            assert "id" in post
            assert "userId" in post
            assert "title" in post
            assert "body" in post
            assert isinstance(post["id"], int)
            assert isinstance(post["userId"], int)
            assert isinstance(post["title"], str)
            assert isinstance(post["body"], str)

class TestErrorHandling:
    def test_invalid_endpoint(self,base_url,session):
        response = session.get(f"{base_url}/invalid-endpoint")
        assert response.status_code == 404

    def test_invalid_method(self,base_url,session):
        response = session.post(f"{base_url}/posts/1", json={"title": "test"})
        assert response.status_code in [200, 201, 404, 405]


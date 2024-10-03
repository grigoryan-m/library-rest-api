<h1>Library API Documentation</h1>
This API provides functionality to manage a library system, including operations to add, modify, view, and delete books. It also includes user authentication with JWT tokens.

<h3>Base URL</h3>
<a href="http://localhost:8080/api/v1">http://localhost:8080/api/v1</a>

<h3>Authentication</h3>
<h4>Login</h4>
<ul>
  <li><b>URL: </b>/auth/login</li>
  <li><b>Method: </b>POST</li>
  <li><b>Description: </b>Logs in a user and returns a JWT token</li>
  <li><b>Request body: </b>
<pre>
    	"name": "string",
        "password": "string"
</pre>
  </li>
  <li>Response:</li>
  <pre>
    "jwt"
  </pre>
</ul>

<h4>Logout</h4>
<ul>
  <li><b>URL: </b>/auth/logout</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Logs out a user</li>
  <li>Response:</li>
  <pre>
    Successfully logged out
  </pre>
</ul>

<h4>Register</h4>
<ul>
  <li><b>URL: </b>/auth/register</li>
  <li><b>Method: </b>POST</li>
  <li><b>Description: </b>Register a user</li>
  <li><b>Request body:</b></li>
  <pre>
    {
    "username": "string",
    "password": "string"
    }
  </pre>
  <li>Response:</li>
  <pre>
    Successfully registered user!
  </pre>
</ul>
<details>
  <summary>ROLE_USER authority</summary>
<h2>Books</h2>
<h3>1. Get all books</h3>
<ul>
  <li><b>URL: </b>/books</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Retrieves a list of all books in the library</li>
  <li>Response:</li>
  <pre>
    [
    {
        "id": 1,
        "title": "The Trial",
        "author": "Franz Kafka",
        "isbn": 9781522952039,
        "status": "available"
    },
    {
        "id": 3,
        "title": "Martin Eden",
        "author": "Jack London",
        "isbn": 9781948132589,
        "status": "available"
    }
]
  </pre>
</ul>

<h3>2. Get a book by ID</h3>
<ul>
  <li><b>URL: </b>/books/{id}</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Retrieves details of a book by its ID</li>
  <li>Response:</li>
  <pre>
    {
        "id": 5,
        "title": "The Oval Portrait",
        "author": "Edgar Allan Poe",
        "isbn": 9781977562555,
        "status": "available"
    }
  </pre>
</ul>

<h3>3. Get books by title</h3>
<ul>
  <li><b>URL: </b>/books/title/{title}</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Retrieves a list of books by title</li>
  <li>Response:</li>
  <pre>
    {
        "id": 1,
        "title": "The Trial",
        "author": "Franz Kafka",
        "isbn": 9781522952039,
        "status": "available"
    }
  </pre>
</ul>

<h3>4. Get books by author</h3>
<ul>
  <li><b>URL: </b>/books/author/{author}</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Retrieves a list of books by author</li>
  <li>Response:</li>
  <pre>
    {
        "id": 1,
        "title": "The Trial",
        "author": "Franz Kafka",
        "isbn": 9781522952039,
        "status": "available"
    }
  </pre>
</ul>

<h3>5. Get a book by isbn</h3>
<ul>
  <li><b>URL: </b>/books/isbn/{isbn}</li>
  <li><b>Method: </b>GET</li>
  <li><b>Description: </b>Retrieves a book by isbn</li>
  <li>Response:</li>
  <pre>
    {
        "id": 1,
        "title": "The Trial",
        "author": "Franz Kafka",
        "isbn": 9781522952039,
        "status": "available"
    }
  </pre>
</ul>
</details>

<details>
  <summary>ROLE_ADMIN authority</summary>
  <h2>Books</h2>
  <h3>1. Add a New Book</h3>
  <ul>
  <li><b>URL: </b>/books/add</li>
  <li><b>Method: </b>POST</li>
  <li><b>Description: </b>Adds a new book</li>
  <li><b>Request body:</b></li>
    <pre>
      "title": "string",
      "author": "string",
      "isbn": bigint,
      "status": "string" [DEFAULT="available"]
    </pre>
  <li>Response:</li>
    <pre>true</pre>
  </ul>
  <h3>2. Delete a book</h3>
  <ul>
    <li><b>URL: </b>/books/delete/{id}</li>
    <li><b>Method: </b>DELETE</li>
    <li><b>Description: </b>Deletes a book based on id</li>
    <li>Response:</li>
    <pre>Successfully deleted the book</pre>
  </ul>
  <h3>3. Change status</h3>
  <ul>
    <li><b>URL: </b>/books/patch/{id}?status={status}</li>
    <li><b>Method: </b>PATCH</li>
    <li><b>Description: </b>Changes status of the book</li>
    <li>Response:</li>
    <pre>
      true
    </pre>
  </ul>
  <h3>4. Edit the book</h3>
  <ul>
    <li><b>URL: </b>/books/update/{id}</li>
    <li><b>Method: </b>PUT</li>
    <li><b>Description: </b>Edits a book based on id</li>
    <li><b>Request body:</b></li>
    <pre>
    {
      "title": "string",
      "author": "string",
      "isbn": bigint,
      "status": "string" [DEFAULT="available"]
    }
    </pre>
  </ul>
</details>

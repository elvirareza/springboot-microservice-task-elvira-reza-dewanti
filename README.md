<h1>Simple Book Management System</h1>
A simple RESTful API for managing books, built with Java, Spring Boot, Maven, and PostgreSQL.

<h2>Tech Stack</h2>
<ul>
    <li>Java 21</li>
    <li>Spring Boot 4.1.1</li>
    <li>Spring Data JPA/Hibernate</li>
    <li>PostgreSQL 14</li>
    <li>Maven 3.9</li>
</ul>

<h2>Features</h2>
<ul>
    <li>Add a new book</li>
    <li>Get all books</li>
    <li>Get book by id</li>
    <li>Update book by id</li>
    <li>Partial update book by id</li>
    <li>Delete book by id</li>
</ul>

<h2>Entity</h2>
<h3>Book Entity</h3>
<table>
    <thead>
        <tr>
            <th>Field</th>
            <th>Type</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>id</td>
            <td>Long/bigint</td>
            <td>Primary Key</td>
        </tr>
        <tr>
            <td>title</td>
            <td>String/varchar(255)</td>
            <td></td>
        </tr>
        <tr>
            <td>author</td>
            <td>String/varchar(255)</td>
            <td></td>
        </tr>
        <tr>
            <td>isbn</td>
            <td>String/varchar(255)</td>
            <td></td>
        </tr>
        <tr>
            <td>publishedDate</td>
            <td>LocalDate/date</td>
            <td></td>
        </tr>
    </tbody>
</table>

<img width="546" height="546" alt="Image" src="https://github.com/user-attachments/assets/0c0277be-9abf-4cde-ab41-d16ce7dd3072" />
<img width="546" height="546" alt="Image" src="https://github.com/user-attachments/assets/f6d861dd-25e0-4677-9486-b73546721d57" />

<h2>Database Setup</h2>

<h4>1. Create a PostgreSQL Database</h4>
<pre><code>CREATE DATABASE assignment;</code></pre>
<p>The database configuration is defined in: <code>/src/main/resources/application.yml</code> </p>
<p>The application expects the following environment variables: POSTGRES_USERNAME, POSTGRES_PASSWORD</p>

<h4>2. Set Environment</h4>
<b>macOS / Linux</b><br>
<pre><code>export POSTGRES_USERNAME=your_username</code></pre>
<pre><code>export POSTGRES_PASSWORD=your_password</code></pre>
<br>
<b>Windows PowerShell</b><br>
<pre><code>$env:POSTGRES_USERNAME="your_username"</code></pre>
<pre><code>$env:POSTGRES_PASSWORD="your_password"</code></pre>

<br>
<p>Alternatively, these variables can be configured in the IDE's Run Configuration.</p>

<h3>How to Run</h3>
<p>Clone the repository.</p>
<pre><code>git clone https://github.com/elvirareza/springboot-microservice-task-elvira-reza-dewanti.git</code></pre>

<p>Make sure PostgreSQL is running and the database has been created.</p>

<p>Run the application using Maven:</p>
<pre><code>mvn spring-boot:run</code></pre>
<p>The application will be available at:</p>
<pre><code>http://localhost:9100/api</code></pre>

<h2>API Endpoints</h2>
<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>GET</td>
            <td><code>/api/books</code></td>
            <td>Get all books</td>
        </tr>
        <tr>
            <td>GET</td>
            <td><code>/api/books/{id}</code></td>
            <td>Get book by id</td>
        </tr>
        <tr>
            <td>POST</td>
            <td><code>/api/books</code></td>
            <td>Add a new book</td>
        </tr>
        <tr>
            <td>PUT</td>
            <td><code>/api/books/{id}</code></td>
            <td>Update book by id</td>
        </tr>
        <tr>
            <td>PATCH</td>
            <td><code>/api/books/{id}</code></td>
            <td>Partial update book by id</td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td><code>/api/books/{id}</code></td>
            <td>Delete a book</td>
        </tr>
    </tbody>
</table>

<h3>Example Request</h3>
<b>Add Book</b>

Endpoint: POST /api/books

Request Body

```
{
  "title": "Confessions",
  "author": "Minato Kanae",
  "isbn": "978-602-52972-9-8",
  "publishedDate": "2019-08-07"
}
```

Response Body

Status code: 201
```
{
  "message": "success",
  "data": {
    "id": 1,
    "title": "Confessions",
    "author": "Minato Kanae",
    "isbn": "978-602-52972-9-8",
    "publishedDate": "2019-08-07"
  }
}
```

<b>Get All Books</b>

Endpoint: GET /api/books

Response Body

Status code: 200
```
{
  "message": "success",
  "data": [
    {
      "id": 1,
      "title": "Confessions",
      "author": "Minato Kanae",
      "isbn": "978-602-52972-9-8",
      "publishedDate": "2019-08-07"
    },
    {
      "id": 2,
      "title": "The Da Vinci Code",
      "author": "Dan Brown",
      "isbn": "978-602-441-402-3",
      "publishedDate": "2026-10-01"
    }
  ]
}
```

<b>Get Book by Id</b>

Endpoint: GET /api/books/1

Response Body

Status code: 200
```
{
  "message": "success",
  "data": {
    "id": 1,
    "title": "Confessions",
    "author": "Minato Kanae",
    "isbn": "978-602-52972-9-8",
    "publishedDate": "2019-08-07"
  }
}
```

<b>Update Book</b>

Endpoint: PUT /api/books/2

Request Body
```
{
    "title": "The Da Vinci Code",
    "author": "Dan Brown",
    "isbn": "978-602-441-402-3",
    "publishedDate": "2026-10-01"
}
```

Response Body

Status code: 200
```
{
  "message": "success",
  "data": {
    "id": 2,
    "title": "The Da Vinci Code",
    "author": "Dan Brown",
    "isbn": "978-602-441-402-3",
    "publishedDate": "2026-10-01"
  }
}
```

<b>Partial Update Book</b>

Endpoint: PATCH /api/books/2

Request Body
```
{
    "title": ""
    "author": ""
    "isbn": ""
    "publishedDate": "2026-10-04"
}
```

Response Body

Status code: 200
```
{
  "message": "success",
  "data": {
    "id": 2,
    "title": "The Da Vinci Code",
    "author": "Dan Brown",
    "isbn": "978-602-441-402-3",
    "publishedDate": "2026-10-04"
  }
}
```

<b>Delete Book</b>

Endpoint: DELETE /api/books/2

Response Body

Status code: 200
```
{
  "message": "success"
}
```

<h2>Future Improvements</h2>
<p>The following improvements can be considered for future development:</p>
<ul>
    <li><b>Soft Delete</b> <p>Use soft deletion for books to preserve historical data and maintain auditability.</p></li>
    <li><b>Pagination & Sorting</b> <p>Add pagination and sorting to collection endpoints to improve performance when handling large datasets.</p></li>
    <li><b>Redis Caching</b> <p>Integrate Redis to cache frequently accessed book data, reducing database queries and improving API response times.</p></li>
</ul>

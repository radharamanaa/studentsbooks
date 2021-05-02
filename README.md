# studentsbooks
Please find a working video on https://vimeo.com/541343329 as of 2 May 2021. This project is still in Development. This project was updated to use REST API for ajax request in book issue page! 


This project uses thymeleaf as View Resolver, hibernate as the JPA Vendor and Spring Data JPA for its data requirements. This application has a librarian login in which he can
issue books to the students. This application is intended to be very simple.

You can see how to use Validations, form Binding to Objects using Thymeleaf in this application.

It will have a librarian logging in, with session validations.
He will be able to add books to the student, with per student getting max of 2 books
He will be able to remove books from the student account.
He is able to add student to the DB.
We are not giving roles to the users according to their levels and permissions(atleast as of now).


As of now, All the Repository beans and service beans are getting created properly!

Simply Clone or download this repo and 
Import as Maven project
Compile
Spring boot run from Maven Goals
Browse from anybrowser to http://localhost:8080
Welcome page is seen

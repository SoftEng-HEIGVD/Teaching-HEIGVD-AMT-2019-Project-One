# Teaching-HEIGVD-AMT-2019-Project-One
## Objectives

The main objective of this project is to apply the patterns and techniques presented during the lectures, and to create a simple multi-tiered application in Java EE.

## Functional requirements

* Pick the **business domain of your choice** (academic planning, travel, sports, social network, gaming, etc.). 
* Design a **simple model**, with a small number of business entities. The only constraint is that there should be at least one **ternary association**. An example is when a "Membership" business entity captures the relationship between a "Employee" entity and a "Group" entity.
* It should be possible to manage the business entities (i.e. perform **CRUD operations** on them).
* It should be possible to **navigate** between the entities (e.g. in the previous example, in a page that shows a list of Memberships, it should be possible to click on one and land on a page that displays its details; from that page, it should be possible to click on a link to arrive on a page showing the details of the Employee).
* **Access to the application is protected**: users have to **register** and **authenticate** before accessing their data. 
* **Data is scoped**: users only see the information they have created. Unless you go the extra mile and implement a feature, where some items can be marked as "public" and are then readable by everyone.

## Constraints

- Apply the **MVC pattern to generate markup (HTML)** on the server, and **not** to expose a REST API.
- Implement business services as **EJBs**.
- Store data in a **relational** database management system.
- Implement data access with **JDBC**.

## Non-functional requirements

* **Automation**
  * It should be possible to build and run the application with 1 script (using Docker in the process)
  * It should be possible to run the different types of automated tests with well documented scripts.
* **Usability**
  * Implement paging at the UI level (deal with 1'000'000 entities).
  * The navigation between the pages should be intuitive.
  * Information provided to users (e.g. error messages) should be clear.
  * The UI must be clean (most of you are not visual designers, it's ok to pick a template but make sure that you customize it and remove the elements that are not useful for your application)
* **Performance**
  * It is possible to implement paging between the service tier and the resources tier. We want to know what is the impact of doing it or not. You will need to design a benchmark to answer this question. You will need to write a report to describe your experiment, to document your measurements and to explain what they mean.
* **Security**
  * Authentication
  * Authorization
* **Testing**
  * **Unit testing**. In the report, you will document how you have tested the different types of components (model, EJBs, servlets). You will provide metrics for your test coverage.
  * **Performance and load testing**.
  * ~~**Automated User Acceptance** testing (with a tool like Selenium, which we will see soon)~~

## Organization

**You will work in teams of 2 students**. For effective learning, it is important that each person works on every aspect (do not split code vs testing, because you will miss learning opportunities).

~~**Deadline for submission: November 10th, 23h.**~~

**Deadline for submission: November 11th, 23h.**



**Deliverables:**

* Clean git repo, with clear instructions on the main README.md for how to build, run and test your application.
* Report as a set of markdown files in a doc folder.
* Links to the various markdown files from the main README.md files.
* What do we want to read in your report?
  * **What** you have implemented (functional aspects). Tell us briefly about the business domain you have selected and describe your business model. A diagram showing the entities and their relationships will help. A couple of screenshots too.
  * **How** you have implemented it. Tell us briefly about the components you had to use across the tiers and if you encountered issues or made choices that you find interesting.
  * You **testing strategy**: we want to see that you understand the role and value of the different types of automated tests. We want to see that you can explain what tools can be used t implement these types of tests. We want to have your opinion on the effectiveness of your test strategy (what do you like and what do you not like about your test suite?)
  * In particular a detailed report about your **experiment** to answer the performance tests. We want a clear description of the experiment. We want numbers, graphs and explanations of what they mean.
  * A list of **known bugs and limitations**.

## Proposed timeline

You don't have to follow this sequence if you prefer to do some of the tasks before. However, if you don't know how to start, this is probably a **decomposition** that will help you.

**Week 1 (October 7th): project structure, domain model, MVC iteration 1, unit testing**

* You should have a project in GitHub (or GitLab). Add your full e-mails, GitHub IDs and the repo URL on this [sheet](https://docs.google.com/spreadsheets/d/1vh1dKHtx6FnlnnNwTdk4VlRpzfjS_htFNRVCUtyKgsQ/edit?usp=sharing).
* You should have selected your business domain (don't waste 2 hours on this, it is not the most important thing). You should have a first version of your business entities and their properties.
* You should have a mockup of your UI.
* You should have a script that builds a fresh Docker image and a `docker-compose.yml` file that uses this image. It should be possible for someone to clone your repo and test your app with 1-2 commands.
* You should have unit test for your domain objects. We will see how to unit test servlets next week.

**Week 2 (October 14th): data access**

* You should have DAOs to access your database and they should implement the CRUD methods with JDBC.
* You should have connected these DAOs to your controllers (up-to-you to decide if / when to use business services in the middle).
* The database should be part of your docker-compose setup.
* You should have procedure to generate test data (and instructions for how to use it in your repo).

**Week 3 (October 21st) : MVC iteration 2**

- This should be an iteration over the UI of your application, where you can improve it, add optional features, etc.

**Week 4 (October 28th): load testing**

* You should be able to explain what is the impact of doing pagination between the business and the resources tier. This should not only be theoretical: you must have designed and run an experiment (benchmark).
* Someone cloning your repo must have all the information to re-run the experiment (and the procedure should be automated as much as possible).

**Week 5 (November 4th): User Acceptance Testing**

* You should have defined test scenarios at the UI level and used a tool such as Selenium to implement them. 
* Someone cloning your repo must have all the information to run the tests.


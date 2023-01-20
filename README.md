<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Build][build-shield]][build-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<div>
  <h3 align="center">URL Shortener - DKB Code Factory coding challenge</h3>
  <p align="center">
    Implementation of a simple API for generating, storing and retrieving shortened URLs,
    as part of the DKB Code Factory technical interview process
    <br />
    <a href="https://github.com/ngaspar/dkb-cf-urlshortener/issues">Report Bug</a>
    ·
    <a href="https://github.com/ngaspar/dkb-cf-urlshortener/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#technicalconsiderations">Technical Considerations</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

For more details about the project's scope, refer to the [assignment document][assignmentdoc-url]
provided by DKB Code Factory

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

* [Kotlin][Kotlin-url]
* [Spring][Spring-url]
* [Gradle][Gradle-url]
* [PostgreSQL][PostgreSQL-url]
* [H2][H2-url]
* [Swagger][Swagger-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

JDK 17, Docker, docker-compose

### Installation

Clean, build and run tests:
```
./gradlew clean build
```  

Install:
```
docker-compose up
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage

API documentation should be available at http://localhost:8080/swagger-ui/index.html

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [x] Base project frame/structure
- [x] Repository and Service implementations
- [ ] Unit tests
- [ ] Clean and complete Swagger documentation
- [ ] Error-free deploy/run
- [ ] Caching

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- TECHNICAL CONSIDERATIONS -->
## Technical Considerations

The chosen approach relies on Nano ID ([JNanoId](https://github.com/aventrix/jnanoid)) as a hashing method, implemented at the service level.
It can be argued that a NoSQL implementation might bring slight performance gains, especially because for this particular solution there are no DB relations. One tradeoff is, if the need for horizontal scaling arises, partitioning methods using NoSQL could increase implementation complexity.

Had this project been successfully completed, it could further be improved with caching (with expiration), possibly also with event streaming (e.g. request for long URL hits cache -> event is published -> repository is notified and increments URL hits).

Unfortunately, and despite referring to other similar projects online for inspiration, I was not able to complete the challenge within the recommended time (2 hours), mainly due to having very little experience with Kotlin. It was, however, a fun little project!

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Nuno Gaspar - [LinkedIn](https://linkedin.com/in/gasparnuno) - info@ngaspar.net

Project Link: [https://github.com/ngaspar/dkb-cf-urlshortener](https://github.com/ngaspar/dkb-cf-urlshortener)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* [Best-README-Template](https://github.com/othneildrew/Best-README-Template)
* [spring initializr](https://start.spring.io)
* [JNanoId](https://github.com/aventrix/jnanoid)
* [Baeldung](https://www.baeldung.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/ngaspar/dkb-cf-urlshortener.svg?style=for-the-badge
[contributors-url]: https://github.com/ngaspar/dkb-cf-urlshortener/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/ngaspar/dkb-cf-urlshortener.svg?style=for-the-badge
[forks-url]: https://github.com/ngaspar/dkb-cf-urlshortener/network/members
[stars-shield]: https://img.shields.io/github/stars/ngaspar/dkb-cf-urlshortener.svg?style=for-the-badge
[stars-url]: https://github.com/ngaspar/dkb-cf-urlshortener/stargazers
[license-shield]: https://img.shields.io/github/license/ngaspar/dkb-cf-urlshortener.svg?style=for-the-badge
[license-url]: https://github.com/ngaspar/dkb-cf-urlshortener/blob/main/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/gasparnuno
[Kotlin-url]: https://kotlinlang.org/
[Spring-url]: https://spring.io/
[Gradle-url]: https://gradle.com/
[build-shield]: https://img.shields.io/circleci/project/github/badges/shields/main?style=for-the-badge
[build-url]: https://circleci.com/gh/badges/shields/tree/main
[assignmentdoc-url]: https://github.com/ngaspar/dkb-cf-urlshortener/docs/new_CodingChallenge_-_Handout_–_URL-Shortener.pdf
[PostgreSQL-url]: https://www.postgresql.org
[H2-url]: https://h2database.com
[Swagger-url]: https://swagger.io
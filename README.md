# Restaurant Review Application

## 안내사항 : Instructions

- You must fork this repository and send a pull request when you finish the assignment.
- Please make your repository public.
- If you have any questions, please post it on the issue of this repository.
- Please write the implementation content at the bottom of README.md.

## Basic Requirement

- Use Spring Boot Framework to implement a restaurant review app.
- Use Spring Data JPA to implement it. You can choose other libraries.
- Use gradle as a build tool.
- Please maintain a consistent coding convention. (camelCase)
- Please follow the REST API specification.
- Commit for each function is required.

### Domain

- Restaurant
- Review

## Functionalities

### Search Review List

- Return the restaurant name and review list.
- The review list can be queried in order or reverse order, supports pagination, and can be searched by review title and content.

### Search one Review

- Return one restaurant name, review title, and review content.

### Update a review

- Review can be updated.

### Create a review

- A review has a title and content.

### Delete a review

- Delete a review.
- Delete data using Hard Delete.

### Register a restaurant

- A restaurant has a restaurant name and restaurant category (Korean, Chinese, Japanese, etc.).
- The date of registration must be recorded.

### Update a restaurant

- You can only change the category of the restaurant.

### 레스토랑 목록 조회 : View All Restaurants

- The entire list of restaurants can be queried.
- You can query the list of restaurants by restaurant category.

### 레스토랑 조회 : View one restaurant

- The restaurant name, category, and restaurant creation date must be returned.

### 레스토랑 삭제 : Delete a restaurant

- Restaurant deletion should not delete written reviews. (Soft Delete)

# Contributors

- [김기현](https://github.com/kim1387) ✨
- [김영준](https://github.com/0BVer) ✨
- [정길연](https://github.com/gilyeon00) ✨
- [최세연](https://github.com/barabobBOB) ✨
- [최우석](https://github.com/Sith-call) ✨


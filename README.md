# Connecting To DB using Spring Data JPA

## Problem Statement

You are working on a project that requires you to create a DB and perform CRUD operations on it. You have decided to use Spring Data JPA to connect to the DB and perform the operations. You have also decided to use SQL or HQl queries to perform the operations. Implement the required functions.

## Requirements
1. Implement the following functions:
    - `getProductById(productId)`: This function should return the details of the product with the given `productId`.
    - `getProductTitlePriceById(productId)`: This function should return the title and price of the product with the given `productId` using projection.
    - `getAllProducts()`: This function should return a list of all the products available in the store.
    - `getAllProductsByCategory(category)`: This function should return a list of all the products available in the store that belong to the given `category`.
    - `getAllCategories()`: This function should return a list of all the categories available in the store.
    - `createProduct(product)`: This function should create a new product with the details provided in the `product` object.
    - `deleteProduct(productId)`: This function should delete the product with the given `productId`.
    - `updateProduct(productId, product)`: This function should update the product with the given `productId` with the new product details provided in the `product` object.
    - `replaceProduct(productId, product)`: This function should replace the product with the given `productId` with the new product details provided in the `product` object.
2. Use @RestController to create the API endpoints and @RequestMapping to map the endpoints to the functions.
3. Use appropriate HTTP methods for each function along with PathVariables and RequestBody where necessary.
4. Use Spring Data JPA to connect to the DB and perform the operations.
5. Use fetch types to optimize the queries and cascade types to handle the relationships between entities.
6. Also try to implement the functions using SQL or HQL queries where possible.

#### Pagination and Sorting
1. Implement pagination and sorting for the `getAllProducts()` function.
2. Take the page number, page size, and sort by field as input from the user and return the paginated and sorted list of products.
3. If user does not provide the page number, page size, or sort by field, use default values.
4. Use `Pageable` interfaces to implement pagination and sorting.

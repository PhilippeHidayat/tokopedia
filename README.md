Design a strategy to handle the scenario where a page needs to load more than
100 rows in the pagination implementation for Payment records.

There are several strategy to handle large loads in pagination type of pages
1. Since the requirement stated to be 100 rows or more (limits and offset is fixed) we could sent the data request with filter(s) as mandatory requirement. This is to ensure the payment data requested is what the requester needs and to prevent unnecessary request to server.
2. Make sure the pagination is implemented on server-side. This is to prevent sending a large bulk of data to client-side and hogging server resources.
3. Consider indexing table columns that is frequently used in filter
4. Implementing cache on request result. This is particularly effective is filter is based on general column such as payment type id. Note that this method won't be effective if user tends to search using specific kind of data (ex: customer id)
5. Using asynchronous method to process the request. This allowed other requests to be processed while data is being fetched, not taking resources on server-side but could make loading time longer than normal.
6. Other possible approach is to use progressive loading on client-side(this possibly won't fulfilled the requirement of 100 row mention above) to split the request into smaller chunks.
7. Other things to be caution is to make sure the process of reading into table payment does not affect writing process to the table. So as not to impact transaction process by customer.


Consider a scenario where the record size is substantial, resulting in slow search
performance. How would you address this issue and improve the search speed
while maintaining a responsive user experience?

1. Splitting database to master and slave. Using slave solely for retrieving information.
2. indexing fields/columns commonly used in filters
3. Cache search result, reducing the needs to execute same search query within certain period of time.
4. Optimize query, making sure the indexed columns is used and unnecessary column is not selected.
5. Implement pagination. Can also consider using infinite scrolling method on client-side.
6. Depending on the record type, we could also use database such as ElasticSearch that is specialize for search engine.
7. Related to point no. 6, denormalizing records that is frequently search can also reduce computation time and retrieve data faster.
8. Monitor performance to identify bottleneck and know where to applied points mention above.
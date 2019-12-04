# Requirements

Our aim is to design a Google Analytic-like backend system that will provide web analytic services that tracks and reports website statistics to our customers. We assume that our service will be implemented in a similar way to Google Analytics, where by customers would include a snippet of JavaScript code to the websites or applications. The code would run on the client side browsers as users interact with the pages. The code would then collect and send the data to our back-end system.

# Abstract Design

At a high level, we can divide our system into two main parts – the application / service layer and the data storage layer. On the application side we require a scalable system that can handle a large amount of traffic and will include service interface and webserver. The data storage layer will also need to be a scalable system that is able to store a large amount of data and handle numerous writes and reads. The system will also require a caching mechanism in order to help reduce the load on the system.

# Services

On any given day we can expect billions of hits and requests, and in order to handle the high volume of load we want to build a system that is load-balanced and has auto scaling such that not all traffic hits a single server and we can increase and decrease resources on demand. There are several tools available that are able to handle container orchestration and manage the containerised applications and their components. For our current design will choose to use Kubernetes which is an open-source system that provides automated deployment, scaling, and core management. We could choose to host this using a cloud services such as Azure or Google Cloud. In the event of system updates, using Kubernetes also allows us to perform rolling updates with no downtime by incremental updating.

# Database

For our database, our prime factors will be flexibility and scalability and so we will consider using a NoSQL database such as MongoDB. To provide redundancy and increase data availability, we will implement replica sets in MongoDB - i.e. store copies of the data on different database servers. We are also able to set the preference for read operations to retrieve data from the secondary servers instead of the primary. This is possible due to the nature of our application, we are not too concerned with the metrics being exact up to the current point in time. This will help to reduce the load on our primary server as well and increase availability. We will also consider sharding our database to further distribute the load across servers.

For sharding our database, we will need to decide on a shard key with high cardinality such that documents are well balanced across the available shards. We could choose, for example, the first letter of the client names or domain names, but this potentially leads to an imbalanced system due to biases in naming conventions. A better alternative that we will implement is to create a hashed sharding key - we will use one of the fields such as the client name and hash it to determine which shard it belongs to.

We make the assumption that customers are more interested in more recent data as opposed to historical data. Our system tracks billions of user interactions with client applications everyday, because of this our database can grow extremely large very quickly. Although we have already looked at horizontally scaling our system, we can consider some improvements to help manage database size, such as archiving. Ideally, we determine a set schedule (for example, monthly) where all data is stored for 30 days and the archived. 

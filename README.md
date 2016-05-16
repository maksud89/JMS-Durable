# JMS-Findings

1. What is the difference between Durable and Persistence in JMS

If we connfigure topic/queue as a persistent then message will survive the server crash. If Jboss get restarted message will be in the destination 
to be consumed by the consumer. 

Durable means, Consumer can consume the message even though consumer is currently offline. 

Messages in Queue are by default Durable, it means,If the consumer is not online when message get delivereed, the message will be still in the
Queue to consume by the consumer once it comes back online.

But for the topic, Message get discarded if the consumer is not online the time message get delivered in the Topic. To prevent this , we can use
Durable topic to make sure message doesn't get lost.

Attached 2 examples are for Durable topic consumer as a standalone consumer of MDB in jboss. 

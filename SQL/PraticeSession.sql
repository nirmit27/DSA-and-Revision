-- Practice Session

-- #1 Status of shipments.
select status shipping_status, count(shipping_id) number_of_shippings
from Shippings
group by status;

-- #2 Total expenditure by customer.
select rank() over(order by sum(o.amount) desc) rank, 
	c.customer_id customer_id, c.first_name first_name, c.last_name last_name, 
	c.country country, sum(o.amount) total_expenditure
from customers c
join orders o
on c.customer_id = o.customer_id
group by c.customer_id
order by sum(o.amount) desc;

-- #3 Total expenditure by item.
select rank() over(order by sum(amount) desc) rank,
	item, sum(amount) total_amount
from orders
group by item
order by sum(amount) desc;

-- #4 Items sold more than once.
select item item_name, count(*) order_count
from orders
group by item
having count(*) > 1;

-- #5 Item having second highest total amount.
select sum(amount) total_amount, item
from orders
group by item
order by sum(amount) desc
limit 1 offset 1;

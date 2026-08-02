
select today.id Id from Weather yesterday cross join Weather today where today.recordDate - yesterday.recordDate = 1 and 
today.temperature > yesterday.temperature;
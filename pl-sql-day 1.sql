-- create the DB
create database fsd_hex_may_25;
use fsd_hex_may_25;

-- create the table 
create table employee(
eid int primary key auto_increment,
ename varchar(255) not null,
ebranch varchar(255),
edepartment varchar(255),
esalary double default 0);

describe employee;

INSERT INTO EMPLOYEE (eid, ename, ebranch, edepartment, esalary) VALUES
(1, 'Amit Sharma', 'Mumbai', 'HR', 75000.00),
(2, 'Priya Patel', 'Delhi', 'IT', 82000.50),
(3, 'Rajesh Kumar', 'Bangalore', 'Finance', 90000.75),
(4, 'Neha Verma', 'Mumbai', 'HR', 78000.25),
(5, 'Vikram Singh', 'Delhi', 'IT', 85000.00),
(6, 'Anjali Gupta', 'Bangalore', 'Finance', 92000.40),
(7, 'Manish Tiwari', 'Mumbai', 'HR', 76000.90),
(8, 'Kavita Reddy', 'Chennai', 'IT', 89000.30),
(9, 'Arjun Nair', 'Bangalore', 'Finance', 94000.20),
(10, 'Sneha Iyer', 'Chennai', 'HR', 77000.10),
(11, 'Suresh Pillai', 'Mumbai', 'IT', 81000.60),
(12, 'Divya Menon', 'Delhi', 'Finance', 93000.80),
(13, 'Ravi Shankar', 'Chennai', 'HR', 74000.55),
(14, 'Pooja Deshmukh', 'Bangalore', 'IT', 86000.95),
(15, 'Karan Mehta', 'Mumbai', 'Finance', 97000.70),
(16, 'Meera Joshi', 'Delhi', 'HR', 73000.15),
(17, 'Akash Bansal', 'Chennai', 'IT', 88000.45),
(18, 'Rohan Agarwal', 'Delhi', 'Finance', 95000.60),
(19, 'Swati Saxena', 'Bangalore', 'HR', 72000.85),
(20, 'Vivek Choudhary', 'Chennai', 'Finance', 96000.90);

select * from employee; 

/* PL SQL : Procedure Language : SQL */

/*Proc 1: Display the list of employees */ 
delimiter $$;    
create procedure proc_emp_list()
BEGIN
	select * from employee;
END;
-- to drop the procedure
drop procedure proc_emp_list;

-- call the procedure 
CALL proc_emp_list();

-- to see all procedures in your DB
show procedure STATUS where db='fsd_hex_may_25'; 

/*Proc 2: Display the list of employees by branch */

DELIMITER $$ 
create procedure proc_emp_by_branch(IN pbranch varchar(255))
BEGIN
	select * from employee where ebranch = pbranch;
END; 

drop procedure proc_emp_by_branch;
CALL proc_emp_by_branch('mumbai');
CALL proc_emp_by_branch('chennai');

/* Proc 3: Compute percentage based on total_marks, marks_scored.*/

DELIMITER $$
create procedure proc_compute_percent(
		IN p_total_marks double, 
        IN p_marks_scored double, 
        OUT percent double)
-- we pass 2 inputs and procedure gives 1 output. 
BEGIN
	IF p_marks_scored > p_total_marks THEN 
		SET percent =0;
	ELSE
		SET percent = (p_marks_scored / p_total_marks) *100; 
	END IF; 
END; 

-- drop the proc
drop procedure proc_compute_percent;

-- create a global/session variable to save this OUT param value of the procedure 
SET @percent = 0;
CALL proc_compute_percent(500,430, @percent);
CALL proc_compute_percent(500,530, @percent);
select @percent AS "percentage scored"; 

/* Sample Study Proc: Compute comsumption bill by taking units and rate as per below calculation
		For first 200 Units: rate=8 
        For above 200 Units: rate=10 [first 200 units @8/unit and remaining @10/unit ]
         
        Your procedure must give final bill value. 
        do ensure that if the units are less than 10, we still charge for 25 units which is our base.
  */
Delimiter $$
create procedure proc_bill(IN p_units double, OUT p_finalbill double)
BEGIN
	IF p_units < 10 THEN
		SET p_finalbill=25*8;
	ELSEIF p_units <=200 THEN
		SET p_finalbill=p_units*8;
    ELSE
		SET p_finalbill=(200*8)+((p_units - 200)*10);
	END IF;
END ;

SET @p_finalbill=0;
CALL proc_bill(600,@p_finalbill);
CALL proc_bill(200,@p_finalbill);
CALL proc_bill(6,@p_finalbill);
select @p_finalbill AS "Final Bill amount";
 
/* Proc 4: procedure to give increments to employees based on their department. 
	take department and percentage as input. 
    update salaries accordingly. 
*/
-- SET session sql_mode = REPLACE (@@session.sql_mode,'STRICT_ALL_TABLE',"" )

SET session sql_safe_updates = 0 ;

DELIMITER $$
create procedure proc_salary_incr(IN p_dept varchar(255), p_incr_percent double)
BEGIN
	
	update employee
    set esalary = esalary + (esalary * (p_incr_percent/100))
    where edepartment = p_dept;
     
END;

drop procedure proc_salary_incr; 

CALL proc_salary_incr("HR", 2);

-- SET session sql_mode = REPLACE (@@session.sql_safe_updates,'STRICT_ALL_TABLE',"" )

/* Loops : basic loop , while loop */

-- Proc to display numbers in loop 
DELIMITER $$
create procedure proc_basic_loop(IN final_num INT )
BEGIN
	declare i INT default 1; 
    declare result varchar(255) default ""; 
    
	loop_lbl:  -- loop label
    LOOP   -- loop begins 
		SET result = concat(result, " " ,i); -- 1 2 3 4 5 
		SET i = i+1;
     
     -- loop termination condition
     IF i > final_num THEN
		LEAVE loop_lbl;
	END IF; 
    
	END LOOP loop_lbl;  -- loop ends 
    select result; 
END;
CALL proc_basic_loop(5)
drop procedure proc_basic_loop;

-- proc for while loop 

DELIMITER $$
create procedure proc_while_loop(IN final_num INT)
BEGIN
	declare i INT default 1; 
     declare result varchar(255) default ""; 
     
	WHILE i<=final_num DO
		SET result = concat(result, " " ,i); -- 1 2 3 4 5 
		SET i = i+1; -- increment i IMP!!
    END WHILE; 
    select result; 
END;
CALL proc_while_loop(5)

-- Proc: fetch all ids from the table 

DELIMITER $$
create procedure proc_all_ids()
BEGIN
	declare i INT default 0;
    declare total_rows INT default 0; 
    declare ids varchar(255) default "";
    declare result varchar(255) default "";
    
    -- count number of records in a table 
    select count(eid) into total_rows from employee; 
    
    while i<total_rows DO
		select eid into ids from employee LIMIT i,1; 
        SET result = concat(result , " " , ids); 
        SET i = i+1;  -- increment 
    end while; 
	select result; 
END; 

drop procedure proc_all_ids;
CALL proc_all_ids();

/* Proc: procedure to give increments to employees based on their department. 
	take department and percentage as input. 
    update salaries accordingly. 
	
    Fetch all Ids from the table satisfying department criteria 1,4,7,9,13,17 
    Since I will be inside the loop, 
    I can call update on these IDs and increment Salary. 
*/
DELIMITER $$
create procedure proc_emp_update_sal_v2(IN p_dept varchar(255), IN p_incr_percent double)
BEGIN
	declare num_rows INT default 0; 
    declare i INT default 0; 
    declare p_id INT default 0; 
    
    select count(eid) into num_rows
    from employee 
    where edepartment = p_dept; 
    
    -- num_rows = 5
    while i<=num_rows DO  -- this loop will be executed as per total records belonging to given department 
		select eid into p_id
        from employee 
        where edepartment = p_dept
        limit i,1; 
      
        -- update this record using p_id
        update employee 
        set esalary = esalary + (esalary * (p_incr_percent/100)) 
        where eid = p_id; 
        
        SET i = i+1; 
    END WHILE; 
END; 

drop procedure proc_emp_update_sal_v2;

CALL proc_emp_update_sal_v2("IT", 35); 

/*
	3 types of parameters
    - IN
    - OUT
    - INOUT  
*/
-- proc for return salary of employee based in given ID 
-- create procedure proc_salary_by_id(IN p_id INT, OUT p_salary double )
DELIMITER $$
create procedure proc_salary_by_id(INOUT myvar varchar(255))
BEGIN
	select esalary into myvar
    from employee
    where eid = myvar; 
END; 
SET @x = 5; 
CALL proc_salary_by_id(@x)
select @x as "Current Salary"; 













 1 teacher - many courses //we can say 1-many OR many-1 (using active and passive voice(English))
 course 1 to 1 coursematerial //cant create CM wOut Course.
 many students - many courses
 
  --------NOT SURE----------------
  student and guardian ==>> i don't think they have a relationship 
  b/c the are seen as one entity 
  b/c guardian is EMBEDED inside student as part of it
  
  in bidirectional @onetomany / @manytoone r/p
  
  1)@OneToMany:- It declares the mappedBy element to indicate the entity that owns the
   bidirectional relationship. Usually, the child entity is one that owns
    the relationship and the parent entity contains the @OneToMany annotation.
    
  2)The child entity, that has the join column, is called the owner of
   	the relationship defined using the @ManyToOne annotation.
  
  3)@JoinColumn Annotation
The @JoinColumn annotation is used to specify the foreign key column in 
the owner of the relationship. The inverse-side of the relationship sets 
the mappedBy attribute to indicate that the relationship is owned by the other entity.

https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

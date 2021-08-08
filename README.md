# hybrid_automation_fw
Include step-by-step test definitions  (Mapping to requirements)

#Requirements :
# Given user is on login page and enters username name and password  to login website
# User should be able to edit map <mapx>
# User should be able to add nodes in map
# User should be able to delete nodes in a map
# User should be able to Add edge in a map
# User should be able to Delete edge ins a map
# User should be able to Add region in a map
# User should be able to Change Region in a map

# Link use cases to test cases (Each use case could be tested with various positive/negative test cases)
#Test Cases:
# Given map should be selected
# Verify user is able to zoom out the map to make modifications sucessfully
# User should be able to edit the map
# Verify node icon icon is selectable on left panel of the map
# Verify edge  icon is selectable on left panel of the  map
# Verify region  icon is selectable on left panel of the map
# Verify add node functionality is successful when user selects node and then marks points in map
# Verify add node functionality is unsuccessful when user doesn't select node and then marks points in map
# Verify user is able to join two nodes in map if mouse pointer is kept on two different nodes
# Verify user is able to join two nodes in map if mouse pointer is kept on exisiting nodes
# Verify straight line is always drawn when nodes are joined
# # Verify user is able to create region having nodes and edges
# Verify user is able to create region in spaces without having nodes and edges
# Verify user is able to create region and drag it to a different location
# Verify user is able to create a region and duplicate it
# Verify user is able to change coordinates of region
# Verify user is able to set the corrodinates on region
# Verify user is able to save changes succcessfully 
# Verify Success message is received on saving the region 
# Verify error message is received when user makes identical changes


#Report test cases with Pass/Fail results and linked defects.
# Fail - Verify user is able to zoom out the map to make modifications sucessfully
# Defect - Zoom in map is not working as expected .On click of zoom out to window sizw, zoom out is not happening

#Document and explain the defects well

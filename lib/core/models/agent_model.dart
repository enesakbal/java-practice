class Agent{
  
  String agentName;
  
  
  Agent({
    required this.agentName
  });

  String getImagePath()=> 'assets/logo/' + agentName + '_icon.png';



}
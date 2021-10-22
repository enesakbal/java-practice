class ValorantMap {
  String mapName;
  
  ValorantMap({required this.mapName});

  String getImagePath() {
    return 'assets/map_icon/' + mapName + '_icon.png';
  }
}

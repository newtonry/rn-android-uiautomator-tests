import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  TouchableOpacity,
  View
} from 'react-native';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isBoxVisible: false };
  };

  toggleBox = () => {
    this.setState({
      isBoxVisible: !this.state.isBoxVisible,
    });
  };

  render() {
    const box = this.state.isBoxVisible ? <View accessibilityLabel={"greenBox"} style={styles.greenBox} /> : null;

    return (
      <View style={styles.container}>
        <TouchableOpacity onPress={this.toggleBox}>
          <Text accessibilityLabel={"toggleButton"}>Toggle the green box</Text>
        </TouchableOpacity>
        {box}
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  greenBox: {
    backgroundColor: 'green',
    height: 50,
    width: 50,
  },
});

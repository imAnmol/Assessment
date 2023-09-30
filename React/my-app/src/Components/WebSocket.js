import React, { useEffect, useState } from 'react';
import WebSocket from 'websocket';

const WebSocketExample = () => {
  const [data, setData] = useState({});

  useEffect(() => {
    const socket = new WebSocket.w3cwebsocket('wss://stream.binance.com:9443/ws/btcusdt@trade');

    socket.onopen = () => {
      console.log('WebSocket connected');
    };

    socket.onmessage = (message) => {
      const parsedData = JSON.parse(message.data);
      console.log(parsedData);
      setData(parsedData);
    };

    socket.onclose = () => {
      console.log('WebSocket disconnected');
    };

    return () => {
      socket.close();
    };
  }, []);

  return (
    <div>
      <h2>Real Time Data of Trades</h2>
      <table>
        <tbody>
          {Object.entries(data).map(([key, value], index) => (
            <tr key={index}>
              <td>{key}</td>
              <td>{value}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default WebSocketExample;

export default async function handler(req, res) {
    const { from, to, amount } = req.query;

    // valida parâmetros mínimos
    if (!from || !to || !amount) {
        return res.status(400).json({ error: "Missing query params" });
    }

    const { ER_API_KEY } = process.env;
    const base = `https://v6.exchangerate-api.com/v6/${ER_API_KEY}/pair`;
    const url  = `${base}/${from}/${to}/${amount}`;

    try {
        const apiRes = await fetch(url);
        const data   = await apiRes.json();
        res.status(200).json(data);
    } catch (err) {
        res.status(500).json({ error: "Proxy error", details: err.message });
    }
}
